package com.codeworld.fc.member.mapper;

import com.codeworld.fc.member.entity.Member;
import com.codeworld.fc.member.response.MemberReceiverAddressInfo;
import com.codeworld.fc.member.response.MemberResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper {
    /**
     * 会员注册
     * @param member
     */
    void registerMember(Member member);

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    Integer checkMemberByPhone(String phone);

    /**
     * 根据手机号获取会员
     * @param phone
     * @return
     */
    MemberResponse getMemberByPhone(String phone);

    /**
     * 根据会员id获取会员基本信息和地址信息
     * @param memberId
     * @return
     */
    MemberReceiverAddressInfo getMemberReceiverAddressByMemberId(Long memberId);

    /**
     * 根据会员id查询会员信息
     * @param memberId
     * @return
     */
    Member getMemberById(Long memberId);
}
