package com.codeworld.fc.auth.client;


import com.codeworld.fc.auth.domain.MerchantResponse;
import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.FCResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("codeworld-cloud-merchant")
public interface MerchantClient {

    @PostMapping("/codeworld-merchant/check-merchant-phone")
    @ApiOperation("根据手机号判断是否被注册")
    FCResponse<Integer> checkMerchantByPhone(@RequestParam("phone") String phone);

    @PostMapping("/codeworld-merchant/get-merchant-phone")
    @ApiOperation("根据手机号获取商户")
    FCResponse<MerchantResponse> getMerchantByPhone(@RequestParam("phone") String phone);

    @PostMapping("/codeworld-merchant/check-merchant-number")
    @ApiOperation("根据商户号判断商户是否注册")
    @PassToken
    FCResponse<Integer> checkMerchantByMerchantNumber(@RequestParam("merchantNumber") String merchantNumber);

    @PostMapping("/codeworld-merchant/get-merchant-number")
    @ApiOperation("根据商户号获取商户")
    @PassToken
    FCResponse<MerchantResponse> getMerchantByMerchantNumber(@RequestParam("merchantNumber") String merchantNumber);

    @PostMapping("/codeworld-merchant/get-merchant-number-name-id")
    @ApiOperation("根据商户id获取商户信息")
    @PassToken
    FCResponse<MerchantResponse> getMerchantInfoById(@RequestParam("merchantId") Long merchantId);
}
