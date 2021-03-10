package com.codeworld.fc.goods.product.mapper;

import com.codeworld.fc.goods.product.entity.ProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductDetailMapper {

    /**
     * 添加商品详情
     * @param productDetail
     */
    void addProductDetail(ProductDetail productDetail);

    /**
     * 根据商品id查询商品详情
     * @param productId
     * @return
     */
    ProductDetail getProductDetailByProductId(Long productId);

    /**
     * 修改商品浏览量
     * @param productDetail
     */
    void updateProductView(ProductDetail productDetail);
}
