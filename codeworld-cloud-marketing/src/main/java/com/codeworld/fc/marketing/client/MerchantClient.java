package com.codeworld.fc.marketing.client;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.marketing.domain.MerchantResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "codeworld-cloud-merchant")
public interface MerchantClient {

    @PostMapping("/codeworld-merchant/get-merchant-number-name-id")
    @ApiOperation("根据商户id获取商户号和名称")
    FCResponse<MerchantResponse> getMerchantNumberAndNameById(@RequestParam("merchantId") Long merchantId);
}
