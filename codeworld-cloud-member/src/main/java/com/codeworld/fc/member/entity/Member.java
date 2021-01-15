package com.codeworld.fc.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName Member
 * Description 会员Model
 * Author Lenovo
 * Date 2020/12/18
 * Version 1.0
**/
@Data
@ApiModel("会员Model")
public class Member {

    @ApiModelProperty("会员主键Id")
    private Long id;

    @ApiModelProperty("会员名称")
    private String name;

    @ApiModelProperty("会员密码")
    private String password;

    @ApiModelProperty("会员手机号")
    private String phone;

    @ApiModelProperty("会员创建时间")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("会员更新时间")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
}
