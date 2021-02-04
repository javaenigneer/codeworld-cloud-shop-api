package com.codeworld.fc.order.client;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.order.client.impl.MemberClientFallBack;
import com.codeworld.fc.order.config.FeignConfiguration;
import com.codeworld.fc.order.domain.MemberInfo;
import com.codeworld.fc.order.domain.ReceiverAddress;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "codeworld-cloud-member",configuration = FeignConfiguration.class)
public interface MemberClient {

    @PostMapping("/codeworld-member/member/get-member-id")
    @ApiOperation("根据会员id获取会员信息")
    @PassToken
    FCResponse<MemberInfo> getMemberById(@RequestParam("memberId") Long memberId);

    @PostMapping("/codeworld-member/address/get-receiver-address-id")
    @ApiOperation("根据地址Id获取地址信息")
    FCResponse<ReceiverAddress> getReceiverAddressByAddressId(@RequestParam("addressId") Long addressId);
}
