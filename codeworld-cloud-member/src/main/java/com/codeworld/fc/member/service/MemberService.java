package com.codeworld.fc.member.service;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.member.domain.MemberInfo;
import com.codeworld.fc.member.request.MemberRegisterRequest;
import com.codeworld.fc.member.response.MemberReceiverAddressInfo;
import com.codeworld.fc.member.response.MemberResponse;

public interface MemberService {
    /**
     * 会员注册
     * @param memberRegisterRequest
     * @return
     */
    FCResponse<Void> registerMember(MemberRegisterRequest memberRegisterRequest);

    /**
     * 根据手机号获取用户
     * @param phone
     * @return
     */
    FCResponse<Integer> checkMemberByPhone(String phone);

    /**
     * 根据手机号获取会员
     * @param phone
     * @return
     */
    FCResponse<MemberResponse> getMemberByPhone(String phone);

    /**
     * 根据会员id获取会员基本信息和地址信息
     * @param memberId
     * @return
     */
    FCResponse<MemberReceiverAddressInfo> getMemberReceiverAddressByMemberId(Long memberId);

    /**
     * 根据会员id获取会员信息
     * @param memberId
     * @return
     */
    FCResponse<MemberInfo> getMemberById(Long memberId);
}
