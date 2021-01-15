package com.codeworld.fc.search.client;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.search.client.impl.ParamClientFallback;
import com.codeworld.fc.search.domain.ParamResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "codeworld-cloud-goods")
public interface ParamClient {

    @PostMapping("/codeworld-goods/param/get-param-category-id")
    @ApiOperation("查询分类下的属性的参数")
    @PassToken
    FCResponse<List<ParamResponse>> getParamByCategoryId(@RequestParam("categoryId") Long categoryId);
}
