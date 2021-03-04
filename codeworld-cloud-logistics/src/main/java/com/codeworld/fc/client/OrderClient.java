package com.codeworld.fc.client;

import com.codeworld.fc.common.response.FCResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "codeworld-cloud-order")
public interface OrderClient {

    @PostMapping("/codeworld-order/check-order-id-and-delivery-number-exist")
    @ApiOperation("根据订单号和物流号查询是否存在")
    FCResponse<Boolean> checkOrderIdAndDeliveryNumberExist(@RequestParam("orderId") Long orderId,
                                                                  @RequestParam("deliveryNumber") String deliveryNumber);
}
