package com.codeworld.fc.order.client;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.order.domain.MemberInfo;
import com.codeworld.fc.order.domain.ReceiverAddress;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("codeworld-cloud-member")
public interface MemberClient {

    @PostMapping("/codeworld-member/member/get-member-id")
    @ApiOperation("根据会员id获取会员信息")
    FCResponse<MemberInfo> getMemberById(@RequestParam("memberId") Long memberId);

    @PostMapping("/codeworld-member/address/get-receiver-address-id")
    @ApiOperation("根据地址Id获取地址信息")
    FCResponse<ReceiverAddress> getReceiverAddressByAddressId(@RequestParam("addressId") Long addressId);
}
