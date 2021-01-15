package com.codeworld.fc.member.response;

import com.codeworld.fc.member.entity.ReceiverAddress;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * ClassName MembeReceiverAddressInfo
 * Description 会员信息、地址信息
 * Author Lenovo
 * Date 2020/12/23
 * Version 1.0
**/
@Data
@ApiModel("会员信息、地址信息")
public class MemberReceiverAddressInfo {

    @ApiModelProperty("会员id")
    private Long id;

    @ApiModelProperty("会员名")
    private String name;

    @ApiModelProperty("会员手机")
    private String phone;

    @ApiModelProperty("收货地址信息")
    List<ReceiverAddress> addresses;

}
