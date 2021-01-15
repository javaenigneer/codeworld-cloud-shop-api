package com.codeworld.fc.order.client;

import com.codeworld.fc.common.response.FCResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "codeworld-cloud-cart")
public interface CartClient {

    @PostMapping("/codeworld-cart/delete-cart-ids")
    @ApiOperation("删除购物车中的信息")
    FCResponse<Void> deleteCartByIds(@RequestParam("cartIds") String cartIds);
}
