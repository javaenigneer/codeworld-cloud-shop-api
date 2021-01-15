package com.codeworld.fc.goods.client;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.FCResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "codeworld-cloud-search")
public interface SearchClient {

    @PostMapping("/codeworld-search/goods/import-goods-to-elasticsearch-time")
    @ApiOperation("将商品定时导入到索引库")
    @PassToken
    FCResponse<Void> importGoodsToElasticSearchTime();
}
