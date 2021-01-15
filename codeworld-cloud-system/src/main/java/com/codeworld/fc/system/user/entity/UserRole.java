package com.codeworld.fc.system.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName UserRole
 * Description 用户角色类
 * Author Lenovo
 * Date 2020/11/4
 * Version 1.0
**/
@Data
@ApiModel("用户角色类")
public class UserRole {

    @ApiModelProperty("用户角色主键Id")
    private Long userRoleId;

    @ApiModelProperty("用户Id")
    private Long userId;

    @ApiModelProperty("角色Id")
    private Long roleId;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm")
    private Date updateTime;

}
