package com.codeworld.fc.auth.response;

import com.codeworld.fc.auth.domain.MemberInfo;
import com.codeworld.fc.auth.domain.ReceiverAddress;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * ClassName MemberInfoResponse
 * Description 会员信息Response
 * Author Lenovo
 * Date 2020/12/23
 * Version 1.0
**/
@Data
@ApiModel("会员信息Response")
public class MemberInfoResponse {

    @ApiModelProperty("会员基本信息")
    MemberInfo memberInfo;

    @ApiModelProperty("收货地址")
    List<ReceiverAddress> receiverAddresses;
}
