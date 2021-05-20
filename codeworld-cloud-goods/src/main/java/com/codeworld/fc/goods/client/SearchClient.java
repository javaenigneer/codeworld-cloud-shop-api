package com.codeworld.fc.goods.client;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.client.impl.SearchClientFallBack;
import com.codeworld.fc.goods.product.response.ProductResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "codeworld-cloud-search")
public interface SearchClient {

    @PostMapping("/codeworld-search/goods/import-goods-to-elasticsearch-time")
    @ApiOperation("将商品定时导入到索引库")
    @PassToken
    FCResponse<Void> importGoodsToElasticSearchTime();

    @PostMapping("/codeworld-search/goods/import-goods-soon")
    @ApiOperation("添加商品后立即导入到ElasticSearch")
    FCResponse<Void> importGoodsSoon(@RequestBody ProductResponse productResponse);

}
