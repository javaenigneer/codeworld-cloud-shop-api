package com.codeworld.fc.order.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName MemberInfo
 * Description 会员信息
 * Author Lenovo
 * Date 2020/12/22
 * Version 1.0
**/
@Data
@ApiModel("会员信息")
public class MemberInfo {

    @ApiModelProperty("会员Id")
    private Long memberId;

    @ApiModelProperty("会员名称")
    private String memberName;

    @ApiModelProperty("会员手机号")
    private String MemberPhone;

    @ApiModelProperty("会员头像")
    private String memberAvatar;

    @ApiModelProperty("会员性别")
    private Integer memberSex;

    public MemberInfo(Long memberId, String memberPhone) {
        this.memberId = memberId;
        MemberPhone = memberPhone;
    }

    public MemberInfo() {
    }
}
