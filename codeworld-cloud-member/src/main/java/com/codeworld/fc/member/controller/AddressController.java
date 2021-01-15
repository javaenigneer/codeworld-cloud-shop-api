package com.codeworld.fc.member.controller;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.member.entity.ReceiverAddress;
import com.codeworld.fc.member.request.AddressAddRequest;
import com.codeworld.fc.member.service.AddressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * ClassName AddressController
 * Description 地址接口管理
 * Author Lenovo
 * Date 2020/12/24
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-member/address")
public class AddressController {

    @Autowired(required = false)
    private AddressService addressService;

    @PostMapping("add-receiver-address")
    @ApiOperation("添加收货地址")
    public FCResponse<Void> addReceiverAddress(@RequestBody @Valid AddressAddRequest addressAddRequest){
        return this.addressService.addReceiverAddress(addressAddRequest);
    }

    @PostMapping("update-receiver-address")
    @ApiOperation("修改收货地址")
    public FCResponse<Void> updateReceiverAddress(@RequestBody @Valid AddressAddRequest addressAddRequest){
        return this.addressService.updateReceiverAddress(addressAddRequest);
    }

    @PostMapping("get-receiver-address-id")
    @ApiOperation("根据地址Id获取地址信息")
    public FCResponse<ReceiverAddress> getReceiverAddressByAddressId(@RequestParam("addressId") Long addressId){
        return this.addressService.getReceiverAddressByAddressId(addressId);
    }

}
