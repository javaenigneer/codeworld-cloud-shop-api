package com.codeworld.fc.search.controller;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.search.domain.ProductResponse;
import com.codeworld.fc.search.domain.ProductSearchRequest;
import com.codeworld.fc.search.request.ProductIndexSearchRequest;
import com.codeworld.fc.search.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName GoodsController
 * Description 商品搜索服务接口管理
 * Author Lenovo
 * Date 2020/12/15
 * Version 1.0
 **/
@RestController
@RequestMapping("codeworld-search/goods")
public class GoodsController {

    @Autowired(required = false)
    public GoodsService goodsService;

    @PostMapping("import-goods-to-elasticsearch")
    @ApiOperation("将商品导入到索引库")
    public FCResponse<Void> importGoodsToElasticSearch() {
        return this.goodsService.importGoodsToElasticSearch();
    }

    @PostMapping("delete-all-goods-to-elasticsearch")
    @ApiOperation("删除索引库所有商品")
    public FCResponse<Void> deleteAllGoodsToElasticSearch() {
        return this.goodsService.deleteAllGoodsToElasticSearch();
    }

    @PostMapping("get-new-product-index")
    @ApiOperation("首页获取最新商品")
    @PassToken
    public FCResponse<List<ProductResponse>> getNewProductIndex(@RequestBody ProductIndexSearchRequest productIndexSearchRequest) {
        return this.goodsService.getNewProductIndex(productIndexSearchRequest);
    }

    @PostMapping("get-product-id")
    @ApiOperation("根据id查询商品")
    @PassToken
    public FCResponse<ProductResponse> getProductById(@RequestParam("productId") Long productId) {
        return this.goodsService.getProductById(productId);
    }

    @PostMapping("import-goods-to-elasticsearch-time")
    @ApiOperation("将商品定时导入到索引库")
    @PassToken
    public FCResponse<Void> importGoodsToElasticSearchTime() {
        return this.goodsService.importGoodsToElasticSearchTime();
    }

    @PostMapping("get-product-category-id")
    @ApiOperation("根据分类Id查询商品")
    @PassToken
    public FCResponse<List<ProductResponse>> getProductByCategoryId(@RequestBody ProductSearchRequest productSearchRequest) {
        return this.goodsService.getProductByCategoryId(productSearchRequest);
    }
}
