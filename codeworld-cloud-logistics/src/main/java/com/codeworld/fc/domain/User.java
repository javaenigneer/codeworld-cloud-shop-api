package com.codeworld.fc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName User
 * Description 用户Model
 * Author Lenovo
 * Date 2020/11/29
 * Version 1.0
**/
@Data
@ApiModel("用户Model")
public class User {

    @ApiModelProperty("主键Id")
    private Long userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户邮箱")
    private String userEmail;

    @ApiModelProperty("用户手机")
    private String userPhone;

    @ApiModelProperty("用户状态")
    private Integer userStatus;

    @ApiModelProperty("用户区域")
    private String areaName;

    @ApiModelProperty("区域Id")
    private Long areaId;

    @ApiModelProperty("用户头像")
    private String avatar;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("密码盐值")
    private String passwordSalt;

    @ApiModelProperty("用户备注")
    private String remark;
}
