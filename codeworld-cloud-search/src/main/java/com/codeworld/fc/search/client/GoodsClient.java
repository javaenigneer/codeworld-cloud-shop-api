package com.codeworld.fc.search.client;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.search.client.impl.GoodsClientFallback;
import com.codeworld.fc.search.domain.ProductDetail;
import com.codeworld.fc.search.domain.ProductResponse;
import com.codeworld.fc.search.domain.ProductSearchRequest;
import com.codeworld.fc.search.domain.ProductSku;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "codeworld-cloud-goods")
public interface GoodsClient {

    @PostMapping("/codeworld-goods/product/get-page-product")
    @ApiOperation("分页查询商品")
    FCResponse<DataResponse<List<ProductResponse>>> getPageProduct(@RequestBody ProductSearchRequest productSearchRequest);

    @PostMapping("/codeworld-goods/product/get-product-sku-product-id")
    @ApiOperation("根据商品id查询所有的Sku")
    @PassToken
    FCResponse<List<ProductSku>> getProductSkuByProductId(@RequestParam("productId") Long productId);

    @PostMapping("/codeworld-goods/product/get-product-detail-product-id")
    @ApiOperation("根据商品id查询商品详情")
    @PassToken
    FCResponse<ProductDetail> getProductDetailByProductId(@RequestParam("productId") Long productId);

    @PostMapping("/codeworld-goods/product/get-page-product-time")
    @ApiOperation("定时分页查询商品")
    @PassToken
    FCResponse<DataResponse<List<ProductResponse>>> getPageProductTime(@RequestBody ProductSearchRequest productSearchRequest);

    @GetMapping("/codeworld-goods/product/get-productResponse/{id}")
    @ApiOperation("根据商品id获取商品信息")
    @PassToken
    FCResponse<ProductResponse> getProductResponseById(@PathVariable("id") Long id);
}
