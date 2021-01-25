package com.codeworld.fc.order.controller;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.order.domain.OrderDeliveryMessage;
import com.codeworld.fc.order.request.OrderAddRequest;
import com.codeworld.fc.order.request.OrderSearchRequest;
import com.codeworld.fc.order.request.PayOrderRequest;
import com.codeworld.fc.order.response.OrderDetailResponse;
import com.codeworld.fc.order.response.OrderPageResponse;
import com.codeworld.fc.order.response.OrderResponse;
import com.codeworld.fc.order.response.OrderStatusCount;
import com.codeworld.fc.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("get-page-member-order")
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

    @PostMapping("get-system-page-order")
    @ApiOperation("系统订单查询显示")
    public FCResponse<DataResponse<List<OrderPageResponse>>> getSystemPageOrder(@RequestBody OrderSearchRequest orderSearchRequest){
        return this.orderService.getSystemPageOrder(orderSearchRequest);
    }

    @PostMapping("get-order-info-id")
    @ApiOperation("根据订单号获取订单信息")
    public FCResponse<OrderDetailResponse> getOrderInfoById(@RequestParam("orderId") Long orderId){
        return this.orderService.getOrderInfoById(orderId);
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
}
