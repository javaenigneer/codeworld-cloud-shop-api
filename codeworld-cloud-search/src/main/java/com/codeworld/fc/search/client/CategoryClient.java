package com.codeworld.fc.search.client;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.search.domain.Category;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "codeworld-cloud-goods")
public interface CategoryClient {

    @PostMapping("/codeworld-goods/category/get-category-id")
    @ApiOperation("根据分类id获取分类信息")
    FCResponse<Category> getCategoryById(@RequestParam("categoryId") Long categoryId);
}
