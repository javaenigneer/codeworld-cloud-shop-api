package com.codeworld.fc.goods.product.service;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.product.entity.ProductDetail;
import com.codeworld.fc.goods.product.entity.ProductSku;
import com.codeworld.fc.goods.product.request.ProductAddRequest;
import com.codeworld.fc.goods.product.request.ProductSearchRequest;
import com.codeworld.fc.goods.product.response.ProductResponse;

import java.util.List;

public interface ProductService {
    /**
     * 分页查询商品列表
     * @param productSearchRequest
     * @return
     */
    FCResponse<DataResponse<List<ProductResponse>>> getPageProduct(ProductSearchRequest productSearchRequest);

    /**
     * 修改商品状态
     * @param id
     * @param status
     * @return
     */
    FCResponse<Void> updateProductStatus(Long id, Integer status);

    /**
     * 添加商品
     * @param productAddRequest
     * @return
     */
    FCResponse<Void> addProduct(ProductAddRequest productAddRequest);

    /**
     * 根据商品id查询所有的Sku
     * @param productId
     * @return
     */
    FCResponse<List<ProductSku>> getProductSkuByProductId(Long productId);

    /**
     * 根据商品id查询商品详情
     * @param productId
     * @return
     */
    FCResponse<ProductDetail> getProductDetailByProductId(Long productId);

    /**
     * 获取最新商品
     * @return
     */
    FCResponse<List<ProductResponse>> getNewProduct();

    /**
     * 定时分页查询商品
     * @param productSearchRequest
     * @return
     */
    FCResponse<DataResponse<List<ProductResponse>>> getPageProductTime(ProductSearchRequest productSearchRequest);

    /**
     * 删除商品
     * @param id
     * @return
     */
    FCResponse<Void> deleteGoods(Long id);
}
