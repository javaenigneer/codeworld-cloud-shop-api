package com.codeworld.fc.member.service;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.member.entity.ReceiverAddress;
import com.codeworld.fc.member.request.AddressAddRequest;

public interface AddressService {

    /**
     * 添加收货人地址
     * @param addressAddRequest
     * @return
     */
    FCResponse<Void> addReceiverAddress(AddressAddRequest addressAddRequest);

    /**
     * 修改收货地址
     * @param addressAddRequest
     * @return
     */
    FCResponse<Void> updateReceiverAddress(AddressAddRequest addressAddRequest);

    /**
     * 根据地址Id获取地址信息
     * @param addressId
     * @return
     */
    FCResponse<ReceiverAddress> getReceiverAddressByAddressId(Long addressId);
}
