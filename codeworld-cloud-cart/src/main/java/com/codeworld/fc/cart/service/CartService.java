package com.codeworld.fc.cart.service;

import com.codeworld.fc.cart.request.CartAddRequest;
import com.codeworld.fc.cart.request.CartRequest;
import com.codeworld.fc.cart.response.CartResponse;
import com.codeworld.fc.common.response.FCResponse;

import java.util.List;

public interface CartService {
    /**
     * 获取用户购物车
     * @param cartRequest
     * @return
     */
    FCResponse<List<CartResponse>> getCartByMemberId(CartRequest cartRequest);

    /**
     * 添加到购物车
     * @param cartAddRequest
     * @return
     */
    FCResponse<Void> addCart(CartAddRequest cartAddRequest);

    /**
     * 删除购物车中的数据
     * @param cartIds
     * @return
     */
    FCResponse<Void> deleteCartByIds(String cartIds);
}
