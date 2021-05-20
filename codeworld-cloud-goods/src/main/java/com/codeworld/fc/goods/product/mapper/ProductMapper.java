package com.codeworld.fc.goods.product.mapper;


import com.codeworld.fc.goods.product.entity.Product;
import com.codeworld.fc.goods.product.request.ProductSearchRequest;
import com.codeworld.fc.goods.product.response.ProductResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {

    /**
     * 分页查询商品列表
     * @param productSearchRequest
     * @return
     */
    List<ProductResponse> getPageProduct(ProductSearchRequest productSearchRequest);

    /**
     * 修改商品状态
     * @param product
     */
    void updateProductStatus(Product product);

    /**
     * 添加商品
     * @param product
     */
    void addProduct(Product product);

    /**
     * 获取最新商品
     * @return
     */
    List<ProductResponse> getNewProduct();

    /**
     * 根据分类id是否关联商品
     * @param categoryId
     * @return
     */
    Integer getBindProductByCategoryId(Long categoryId);

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    Product getProductById(Long id);

    /**
     *
     * @param id
     * @return
     */
    ProductResponse getProductResponseById(Long id);
}
