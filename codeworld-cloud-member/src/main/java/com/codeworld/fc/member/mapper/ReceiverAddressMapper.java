package com.codeworld.fc.member.mapper;

import com.codeworld.fc.member.entity.Member;
import com.codeworld.fc.member.entity.ReceiverAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReceiverAddressMapper {

    /**
     * 根据会员id查询收货地址
     * @param memberId
     * @return
     */
    List<ReceiverAddress> getReceiverAddressByMemberId(Long memberId);

    /**
     * 添加地址信息
     * @param receiverAddress
     */
    void addReceiverAddress(ReceiverAddress receiverAddress);

    /**
     * 修改地址
     * @param receiverAddress
     */
    void updateReceiverAddress(ReceiverAddress receiverAddress);

    /**
     * 根据地址Id获取地址信息
     * @param addressId
     * @return
     */
    ReceiverAddress getReceiverAddressByAddressId(Long addressId);
}
