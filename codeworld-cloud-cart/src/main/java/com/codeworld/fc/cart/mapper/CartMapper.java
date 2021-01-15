package com.codeworld.fc.cart.mapper;

import com.codeworld.fc.cart.entity.Cart;
import com.codeworld.fc.cart.request.CartRequest;
import com.codeworld.fc.cart.response.CartResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper {

    /**
     * 获取用户购物车
     * @param cartRequest
     * @return
     */
    List<CartResponse> getCartByMemberId(CartRequest cartRequest);

    /**
     * 添加到购物车
     * @param cart
     */
    void addCart(Cart cart);

    /**
     * 删除购物车
     * @param cartId
     */
    void deleteCartByIds(List<Long> cartId);
}
