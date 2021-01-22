package com.codeworld.fc.auth.client;

import com.codeworld.fc.auth.client.impl.MemberClientFallBack;
import com.codeworld.fc.auth.domain.MemberReceiverAddressInfo;
import com.codeworld.fc.auth.domain.MemberResponse;
import com.codeworld.fc.common.response.FCResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "codeworld-cloud-member")
public interface MemberClient {

    @PostMapping("/codeworld-member/member/check-member-phone")
    @ApiOperation("根据手机号获取用户")
    FCResponse<Integer> checkMemberByPhone(@RequestParam("phone") String phone);

    @PostMapping("/codeworld-member/member/get-member-phone")
    @ApiOperation("根据手机号获取会员")
    FCResponse<MemberResponse> getMemberByPhone(@RequestParam("phone") String phone);

    @PostMapping("/codeworld-member/member/get-member-receiver-address-id")
    @ApiOperation("根据会员id获取会员基本信息和地址信息")
    FCResponse<MemberReceiverAddressInfo> getMemberReceiverAddressByMemberId(@RequestParam("memberId") Long memberId);
}
