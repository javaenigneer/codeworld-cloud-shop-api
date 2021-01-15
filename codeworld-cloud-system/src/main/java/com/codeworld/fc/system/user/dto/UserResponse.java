package com.codeworld.fc.system.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName UserResponse
 * Description 用户列表返回信息DTO
 * Author Lenovo
 * Date 2020/11/29
 * Version 1.0
**/
@Data
@ApiModel("用户列表返回信息DTO")
public class UserResponse {

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
    @ApiModelProperty("用户角色")
    private String userRole;
    @ApiModelProperty("用户部门")
    private String userDept;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
