package com.codeworld.fc.goods.product.mapper;

import com.codeworld.fc.goods.product.entity.ProductSku;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductSkuMapper {
    /**
     * 添加sku
     * @param productSku
     */
    void addProductSku(ProductSku productSku);

    /**
     * 根据商品id查询所有的sku
     * @param productId
     * @return
     */
    List<ProductSku> getProductSkuByProductId(Long productId);
}
