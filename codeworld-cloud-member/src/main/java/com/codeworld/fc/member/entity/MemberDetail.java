package com.codeworld.fc.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName MemberDetail
 * Description 会员详细信息Model
 * Author Lenovo
 * Date 2020/12/25
 * Version 1.0
**/
@Data
@ApiModel("会员详细信息Model")
public class MemberDetail {

    @ApiModelProperty("会员Id")
    private Long memberId;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("性别")
    private Integer sex;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
}
