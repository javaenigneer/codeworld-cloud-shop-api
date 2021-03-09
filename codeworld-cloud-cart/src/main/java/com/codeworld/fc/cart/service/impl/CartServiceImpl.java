package com.codeworld.fc.cart.service.impl;

import com.codeworld.fc.cart.domain.ProductModel;
import com.codeworld.fc.cart.domain.ProductSkuModel;
import com.codeworld.fc.cart.entity.Cart;
import com.codeworld.fc.cart.mapper.CartMapper;
import com.codeworld.fc.cart.request.CartAddRequest;
import com.codeworld.fc.cart.request.CartRequest;
import com.codeworld.fc.cart.response.CartResponse;
import com.codeworld.fc.cart.service.CartService;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.common.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName CartServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/12/25
 * Version 1.0
**/
@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired(required = false)
    private CartMapper cartMapper;

    /**
     * 获取用户购物车
     *
     * @param cartRequest
     * @return
     */
    @Override
    public FCResponse<List<CartResponse>> getCartByMemberId(CartRequest cartRequest) {
        List<CartResponse> cartResponses = this.cartMapper.getCartByMemberId(cartRequest);

        if (CollectionUtils.isEmpty(cartResponses)){
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.cart.CART_DATA_EMPTY.getMsg(),cartResponses);
        }
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.cart.CART_DATA_SUCCESS.getMsg(),cartResponses);
    }

    /**
     * 添加到购物车
     *
     * @param cartAddRequest
     * @return
     */
    @Override
    public FCResponse<Void> addCart(CartAddRequest cartAddRequest) {
        try {
            Cart cart = new Cart();
            // 将Json转换为对象
            ProductModel productModel = JsonUtils.parse(cartAddRequest.getProductDetail(), ProductModel.class);
            cart.setId(IDGeneratorUtil.getNextId());
            cart.setMemberId(cartAddRequest.getMemberId());
            assert productModel != null;
            cart.setProductId(productModel.getProductId());
            cart.setProductCount(productModel.getProductCount());
            cart.setProductImage(productModel.getProductImage());
            cart.setMerchantNumber(productModel.getMerchantNumber());
            ProductSkuModel productSkuModel = JsonUtils.parse(cartAddRequest.getSkuDetail(), ProductSkuModel.class);
            cart.setProductSku(cartAddRequest.getSkuDetail());
            assert productSkuModel != null;
            cart.setProductSkuId(productSkuModel.getId());
            cart.setProductTitle(productSkuModel.getTitle());
            cart.setProductStatus(1);
            cart.setProductPrice(productSkuModel.getPrice());
            cart.setCreateTime(new Date());
            // 添加到购物车
            // 首先判断商品是否加入过购物车
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("memberId",cartAddRequest.getMemberId());
            map.put("productId",productModel.getProductId());
            map.put("productSkuId",productSkuModel.getId());
            Long cartId = this.cartMapper.checkCartExist(map);
            if (ObjectUtils.isNotEmpty(cartId)){
                // 已存在,直接修改数量
                Cart updateCart = new Cart();
                updateCart.setId(cartId);
                updateCart.setProductCount(productModel.getProductCount());
                this.cartMapper.updateCartProductCount(updateCart);
            }else {
                // 不存在，新增到购物车中
                this.cartMapper.addCart(cart);
            }
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.cart.CART_ADD_SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 删除购物车中的数据
     *
     * @param cartIds
     * @return
     */
    @Override
    public FCResponse<Void> deleteCartByIds(String cartIds) {
        if (ObjectUtils.isEmpty(cartIds)){
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(),HttpMsg.cart.CART_ID_ERROR.getMsg());
        }
        try {
            List<Long> cartId = JsonUtils.parseList(cartIds, Long.class);
            this.cartMapper.deleteCartByIds(cartId);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.cart.CART_DELETE_SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }
}
