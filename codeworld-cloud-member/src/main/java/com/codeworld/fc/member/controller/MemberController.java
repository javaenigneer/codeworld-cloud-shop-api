package com.codeworld.fc.member.controller;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.member.domain.MemberInfo;
import com.codeworld.fc.member.request.MemberRegisterRequest;
import com.codeworld.fc.member.response.MemberReceiverAddressInfo;
import com.codeworld.fc.member.response.MemberResponse;
import com.codeworld.fc.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName MemberController
 * Description 会员管理接口
 * Author Lenovo
 * Date 2020/12/18
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-member/member")
@Api(tags = "会员管理接口")
public class MemberController {

    @Autowired(required = false)
    private MemberService memberService;

    @PostMapping("register-member")
    @ApiOperation("会员注册")
    @PassToken
    public FCResponse<Void> registerMember(@RequestBody MemberRegisterRequest memberRegisterRequest){
        return this.memberService.registerMember(memberRegisterRequest);
    }

    @PostMapping("check-member-phone")
    @ApiOperation("根据手机号判断用户是否注册")
    @PassToken
    public FCResponse<Integer> checkMemberByPhone(@RequestParam("phone") String phone){
        return this.memberService.checkMemberByPhone(phone);
    }

    @PostMapping("get-member-phone")
    @ApiOperation("根据手机号获取会员")
    @PassToken
    public FCResponse<MemberResponse> getMemberByPhone(@RequestParam("phone") String phone){
        return this.memberService.getMemberByPhone(phone);
    }

    @PostMapping("get-member-receiver-address-id")
    @ApiOperation("根据会员id获取会员基本信息和地址信息")
    public FCResponse<MemberReceiverAddressInfo> getMemberReceiverAddressByMemberId(@RequestParam("memberId") Long memberId){
        return this.memberService.getMemberReceiverAddressByMemberId(memberId);
    }

    @PostMapping("get-member-id")
    @ApiOperation("根据会员id获取会员信息")
    @PassToken
    public FCResponse<MemberInfo> getMemberById(@RequestParam("memberId") Long memberId){
        return this.memberService.getMemberById(memberId);
    }
}
