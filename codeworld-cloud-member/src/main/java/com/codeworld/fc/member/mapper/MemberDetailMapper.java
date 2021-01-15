package com.codeworld.fc.member.mapper;

import com.codeworld.fc.member.entity.MemberDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDetailMapper {


    /**
     * 根据会员id查询会员详细信息
     * @param memberId
     * @return
     */
    MemberDetail getMemberDetailByMemberId(Long memberId);
}
