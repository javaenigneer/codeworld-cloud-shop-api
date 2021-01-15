package com.codeworld.fc.member.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.member.entity.ReceiverAddress;
import com.codeworld.fc.member.mapper.ReceiverAddressMapper;
import com.codeworld.fc.member.request.AddressAddRequest;
import com.codeworld.fc.member.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ClassName AddressServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/12/24
 * Version 1.0
**/
@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    @Autowired(required = false)
    private ReceiverAddressMapper receiverAddressMapper;

    /**
     * 添加收货人地址
     *
     * @param addressAddRequest
     * @return
     */
    public FCResponse<Void> addReceiverAddress(AddressAddRequest addressAddRequest) {

        ReceiverAddress receiverAddress = new ReceiverAddress();
        BeanUtil.copyProperties(addressAddRequest,receiverAddress);
        receiverAddress.setId(IDGeneratorUtil.getNextId());
        receiverAddress.setCreateTime(new Date());
        receiverAddress.setUpdateTime(receiverAddress.getCreateTime());
        this.receiverAddressMapper.addReceiverAddress(receiverAddress);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.address.ADDRESS_ADD_SUCCESS.getMsg());
    }

    /**
     * 修改收货地址
     *
     * @param addressAddRequest
     * @return
     */
    public FCResponse<Void> updateReceiverAddress(AddressAddRequest addressAddRequest) {
        if (ObjectUtils.isEmpty(addressAddRequest.getId()) || addressAddRequest.getId() <= 0){
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(),HttpMsg.address.ADDRESS_ID_ERROR.getMsg());
        }
        ReceiverAddress receiverAddress = new ReceiverAddress();
        BeanUtil.copyProperties(addressAddRequest,receiverAddress);
        receiverAddress.setUpdateTime(new Date());
        this.receiverAddressMapper.updateReceiverAddress(receiverAddress);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.address.ADDRESS_UPDATE_SUCCESS.getMsg());
    }

    /**
     * 根据地址Id获取地址信息
     *
     * @param addressId
     * @return
     */
    @Override
    public FCResponse<ReceiverAddress> getReceiverAddressByAddressId(Long addressId) {
        if (ObjectUtils.isEmpty(addressId) || addressId <= 0){
            log.error("地址ID错误：{}",addressId);
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(),HttpMsg.address.ADDRESS_ID_ERROR.getMsg());
        }
        ReceiverAddress receiverAddress = this.receiverAddressMapper.getReceiverAddressByAddressId(addressId);
        if (ObjectUtils.isEmpty(receiverAddress)){
            log.error("无地址信息：{}",addressId);
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(),HttpMsg.address.ADDRESS_DATA_EMPTY.getMsg());
        }
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.address.ADDRESS_DATA_SUCCESS.getMsg(),receiverAddress);
    }
}
