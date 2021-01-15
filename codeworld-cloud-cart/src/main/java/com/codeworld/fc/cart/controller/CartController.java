package com.codeworld.fc.cart.controller;

import com.codeworld.fc.cart.request.CartAddRequest;
import com.codeworld.fc.cart.request.CartRequest;
import com.codeworld.fc.cart.response.CartResponse;
import com.codeworld.fc.cart.service.CartService;
import com.codeworld.fc.common.response.FCResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ClassName CartController
 * Description 购物车接口管理
 * Author Lenovo
 * Date 2020/12/25
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-cart")
@Api(tags = "购物车接口管理")
public class CartController {

    @Autowired(required = false)
    private CartService cartService;

    @PostMapping("get-cart-member-id")
    @ApiOperation("获取用户购物车")
    public FCResponse<List<CartResponse>> getCartByMemberId(@RequestBody CartRequest cartRequest){
        return this.cartService.getCartByMemberId(cartRequest);
    }

    @PostMapping("add-cart")
    @ApiOperation("添加到购物车")
    public FCResponse<Void> addCart(@RequestBody @Valid CartAddRequest cartAddRequest){
        return this.cartService.addCart(cartAddRequest);
    }

    @PostMapping("delete-cart-ids")
    @ApiOperation("删除购物车中的信息")
    public FCResponse<Void> deleteCartByIds(@RequestParam("cartIds") String cartIds){
        return this.cartService.deleteCartByIds(cartIds);
    }
}
