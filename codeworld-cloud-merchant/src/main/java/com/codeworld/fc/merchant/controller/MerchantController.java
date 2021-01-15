package com.codeworld.fc.merchant.controller;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.merchant.request.ExamineMerchantRequest;
import com.codeworld.fc.merchant.request.MerchantAddRequest;
import com.codeworld.fc.merchant.request.MerchantRegisterRequest;
import com.codeworld.fc.merchant.request.MerchantSearchRequest;
import com.codeworld.fc.merchant.response.MerchantResponse;
import com.codeworld.fc.merchant.service.MerchantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * ClassName MerchantController
 * Description 商户接口管理
 * Author Lenovo
 * Date 2020/12/30
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-merchant")
@Api(tags = "商户接口管理")
public class MerchantController {

    @Autowired(required = false)
    private MerchantService merchantService;

    @PostMapping("register-merchant")
    @ApiOperation("商户注册")
    @PassToken
    public FCResponse<String> registerMerchant(@RequestBody @Valid MerchantRegisterRequest merchantRegisterRequest){
        return this.merchantService.registerMerchant(merchantRegisterRequest);
    }

    @PostMapping("check-merchant-phone")
    @ApiOperation("根据手机号判断是否被注册")
    @PassToken
    public FCResponse<Integer> checkMerchantByPhone(@RequestParam("phone") String phone){
        return this.merchantService.checkMerchantByPhone(phone);
    }

    @PostMapping("get-merchant-phone")
    @ApiOperation("根据手机号获取商户")
    @PassToken
    public FCResponse<MerchantResponse> getMerchantByPhone(@RequestParam("phone") String phone){
        return this.merchantService.getMerchantByPhone(phone);
    }

    @PostMapping("merchant-settled")
    @ApiOperation("商家入驻")
    public FCResponse<Void> merchantSettled(@RequestBody @Valid MerchantAddRequest merchantAddRequest){
        return this.merchantService.merchantSettled(merchantAddRequest);
    }

    @PostMapping("get-page-merchant")
    @ApiOperation("分页查询商户")
    public FCResponse<DataResponse<List<MerchantResponse>>> getPageMerchant(@RequestBody MerchantSearchRequest merchantSearchRequest){
        return this.merchantService.getPageMerchant(merchantSearchRequest);
    }

    @PostMapping("check-merchant-number")
    @ApiOperation("根据商户号判断商户是否注册")
    @PassToken
    public FCResponse<Integer> checkMerchantByMerchantNumber(@RequestParam("merchantNumber") String merchantNumber){
        return this.merchantService.checkMerchantByMerchantNumber(merchantNumber);
    }

    @PostMapping("get-merchant-number")
    @ApiOperation("根据商户号获取商户")
    @PassToken
    public FCResponse<MerchantResponse> getMerchantByMerchantNumber(@RequestParam("merchantNumber") String merchantNumber){
        return this.merchantService.getMerchantByMerchantNumber(merchantNumber);
    }

    @PostMapping("examine-merchant")
    @ApiOperation("审核商户")
    public FCResponse<Void> examineMerchant(@RequestBody @Valid ExamineMerchantRequest examineMerchantRequest){
        return this.merchantService.examineMerchant(examineMerchantRequest);
    }

    @PostMapping("get-merchant-number-name-id")
    @ApiOperation("根据商户id获取商户信息")
    @PassToken
    public FCResponse<MerchantResponse> getMerchantInfoById(@RequestParam("merchantId") Long merchantId){
        return this.merchantService.getMerchantNumberAndNameById(merchantId);
    }


}
