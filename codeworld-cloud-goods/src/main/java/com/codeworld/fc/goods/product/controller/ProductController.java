package com.codeworld.fc.goods.product.controller;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.product.entity.ProductDetail;
import com.codeworld.fc.goods.product.entity.ProductSku;
import com.codeworld.fc.goods.product.request.ProductAddRequest;
import com.codeworld.fc.goods.product.request.ProductSearchRequest;
import com.codeworld.fc.goods.product.response.ProductResponse;
import com.codeworld.fc.goods.product.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ClassName ProductController
 * Description 商品信息接口管理
 * Author Lenovo
 * Date 2020/11/28
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-goods")
public class ProductController {

    @Autowired(required = false)
    private ProductService productService;

    @PostMapping("/product/get-page-product")
    @ApiOperation("分页查询商品")
    public FCResponse<DataResponse<List<ProductResponse>>> getPageProduct(@RequestBody ProductSearchRequest productSearchRequest){
        return this.productService.getPageProduct(productSearchRequest);
    }

    @PostMapping("/product/update-product-status")
    @ApiOperation("修改商品状态")
    public FCResponse<Void> updateProductStatus(@RequestParam("id") Long id, @RequestParam("status") Integer status){
        return this.productService.updateProductStatus(id,status);
    }

    @PostMapping("/product/add-product")
    @ApiOperation("添加商品")
    public FCResponse<Void> addProduct(@RequestBody @Valid ProductAddRequest productAddRequest){
        return this.productService.addProduct(productAddRequest);
    }

    @PostMapping("/product/get-product-sku-product-id")
    @ApiOperation("根据商品id查询所有的Sku")
    @PassToken
    public FCResponse<List<ProductSku>> getProductSkuByProductId(@RequestParam("productId") Long productId){
        return this.productService.getProductSkuByProductId(productId);
    }

    @PostMapping("/product/get-product-detail-product-id")
    @ApiOperation("根据商品id查询商品详情")
    @PassToken
    public FCResponse<ProductDetail> getProductDetailByProductId(@RequestParam("productId") Long productId){
        return this.productService.getProductDetailByProductId(productId);
    }

    @PostMapping("/product/get-new-product")
    @ApiOperation("获取最新商品")
    public FCResponse<List<ProductResponse>> getNewProduct(){
        return this.productService.getNewProduct();
    }

    @PostMapping("/product/get-page-product-time")
    @ApiOperation("定时分页查询商品")
    @PassToken
    public FCResponse<DataResponse<List<ProductResponse>>> getPageProductTime(@RequestBody ProductSearchRequest productSearchRequest){
        return this.productService.getPageProductTime(productSearchRequest);
    }


    @PostMapping("/product/delete-goods/{id}")
    @ApiOperation("删除商品")
    public FCResponse<Void> deleteGoods(@PathVariable("id") Long id){
        return this.productService.deleteGoods(id);
    }

    @GetMapping("/product/get-productResponse/{id}")
    @ApiOperation("根据商品id获取商品信息")
    @PassToken
    public FCResponse<ProductResponse> getProductResponseById(@PathVariable("id") Long id){
        return this.productService.getProductResponseById(id);
    }

    @PostMapping("/product/examine-product")
    @ApiOperation("审核商品")
    public FCResponse<Void> examineProduct(@RequestParam("productId") Long productId,
                                           @RequestParam("approveStatus") Integer approveStatus){
        return this.productService.examineProduct(productId,approveStatus);
    }
}
