package com.codeworld.fc.order.controller;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.order.domain.OrderDeliveryMessage;
import com.codeworld.fc.order.request.*;
import com.codeworld.fc.order.response.*;
import com.codeworld.fc.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * ClassName OrderController
 * Description 订单接口管理
 * Author Lenovo
 * Date 2020/12/28
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-order")
@Api(tags = "订单接口管理")
public class OrderController {

    @Autowired(required = false)
    private OrderService orderService;

    @PostMapping("create-order")
    @ApiOperation("创建订单")
    public FCResponse<String> createOrder(@RequestBody @Valid OrderAddRequest orderAddRequest){
        return this.orderService.createOrder(orderAddRequest);
    }

    @PostMapping("/app/get-page-member-order")
    @ApiOperation("分页查询当前会员订单信息")
    public FCResponse<List<OrderResponse>> getPageMemberOrder(@RequestBody OrderSearchRequest orderSearchRequest){
        return this.orderService.getPageMemberOrder(orderSearchRequest);
    }

    @PostMapping("pay-order")
    @ApiOperation("支付订单")
    public FCResponse<Void> payOrder(@RequestBody PayOrderRequest payOrderRequest){
        return this.orderService.payOrder(payOrderRequest);
    }

    // 查询商户下的订单信息
    @PostMapping("get-page-merchant-order")
    @ApiOperation("查询商户下的订单信息")
    public FCResponse<List<OrderResponse>> getPageMerchantOrder(@RequestBody OrderSearchRequest orderSearchRequest){
        return this.orderService.getPageMerchantOrder(orderSearchRequest);
    }

    // 查询web端商户下的订单列表
    @PostMapping("/web/get-page-merchant-order")
    @ApiOperation("查询商户下的订单列表")
    public FCResponse<DataResponse<List<OrderPageResponse>>> getWebPageMerchantOrder(@RequestBody OrderSearchRequest orderSearchRequest){
        return this.orderService.getWebPageMerchantOrder(orderSearchRequest);
    }

    @PostMapping("get-system-page-order")
    @ApiOperation("系统订单查询显示")
    public FCResponse<DataResponse<List<OrderPageResponse>>> getSystemPageOrder(@RequestBody OrderSearchRequest orderSearchRequest){
        return this.orderService.getSystemPageOrder(orderSearchRequest);
    }

    @PostMapping("get-order-info-id")
    @ApiOperation("根据订单号获取订单信息")
    public FCResponse<OrderDetailResponse> getOrderInfoById(@RequestParam("orderDetailId") Long orderDetailId){
        return this.orderService.getOrderInfoById(orderDetailId);
    }

    @PostMapping("get-order-status-count")
    @ApiOperation("获取订单状态下的数量")
    public FCResponse<OrderStatusCount> getOrderStatusCount(){
        return this.orderService.getOrderStatusCount();
    }

    @PostMapping("order-delivery")
    @ApiOperation("订单发货")
    public FCResponse<Void> orderDelivery(@RequestBody @Valid OrderDeliveryMessage orderDeliveryMessage){
        return this.orderService.orderDelivery(orderDeliveryMessage);
    }

    @PostMapping("/app/refund-order")
    @ApiOperation("订单退款")
    public FCResponse<Void> refundOrder(@RequestParam("orderDetailId") Long orderDetailId){
        return this.orderService.refundOrder(orderDetailId);
    }

    @PostMapping("/web/get-page-merchant-order-return")
    @ApiOperation("获取商户下订单退款退货列表")
    public FCResponse<DataResponse<List<OrderReturnResponse>>> getPageMerchantOrderReturn(@RequestBody OrderSearchRequest orderSearchRequest){
        return this.orderService.getPageMerchantOrderReturn(orderSearchRequest);
    }

    @PostMapping("/web/get-order-return-info")
    @ApiOperation("获取订单退款退货详情")
    public FCResponse<OrderReturnDetailResponse> getOrderReturnInfo(@RequestParam("orderReturnId") Long orderReturnId){
        return this.orderService.getOrderReturnInfo(orderReturnId);
    }

    @PostMapping("/web/receive-processing-service-order")
    @ApiOperation("接受处理订单服务")
    public FCResponse<Void> receiveProcessingServiceOrder(@RequestBody @Valid OrderProcessingRequest orderProcessingRequest){
        return this.orderService.receiveProcessingServiceOrder(orderProcessingRequest);
    }

    @PostMapping("/web/refuse-process-service-order")
    @ApiOperation("拒绝处理订单服务")
    public FCResponse<Void> refuseProcessServiceOrder(@RequestBody @Valid OrderProcessingRequest orderProcessingRequest){
        return this.orderService.refuseProcessServiceOrder(orderProcessingRequest);
    }

    @PostMapping("/web/export-order")
    @ApiOperation("导出订单数据")
    public void exportOrder(HttpServletResponse response){
        this.orderService.exportExcel(response);
    }

    @PostMapping("/app/cancel-order")
    @ApiOperation("app端取消订单")
    public FCResponse<Void> cancelOrder(@RequestParam("orderId") Long orderId){
        return this.orderService.cancelOrder(orderId);
    }

    @PostMapping("/web/get-merchant-dashboard-data")
    @ApiOperation("web端获取商户dashboard基本数据")
    public FCResponse<MerchantDashBoardData> getMerchantDashBoardData(){
        return this.orderService.getMerchantDashBoardData();
    }

    @PostMapping("/app/confirm-receipt")
    @ApiOperation("订单收货")
    public FCResponse<Void> confirmReceipt(@RequestParam("orderDetailId") Long orderDetailId){
        return this.orderService.confirmReceipt(orderDetailId);
    }

    @PostMapping("/app/order-product-evaluation")
    @ApiOperation("订单商品评价")
    public FCResponse<Void> orderProductEvaluation(@RequestBody @Valid OrderEvaluationRequest orderEvaluationRequest){
        return this.orderService.orderProductEvaluation(orderEvaluationRequest);
    }

    @PostMapping("/app/order-return-apply")
    @ApiOperation("订单退货申请")
    public FCResponse<Void> orderReturnApply(@RequestBody @Valid OrderReturnRequest orderReturnRequest){
        return this.orderService.orderReturnApply(orderReturnRequest);
    }

    @PostMapping("check-order-id-and-delivery-number-exist")
    @ApiOperation("根据订单号和物流号查询是否存在")
    public FCResponse<Boolean> checkOrderIdAndDeliveryNumberExist(@RequestParam("orderId") Long orderId,
                                                                  @RequestParam("deliveryNumber") String deliveryNumber){
        return this.orderService.checkOrderIdAndDeliveryNumberExist(orderId,deliveryNumber);
    }
}
