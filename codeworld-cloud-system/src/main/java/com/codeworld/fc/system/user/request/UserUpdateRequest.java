package com.codeworld.fc.system.user.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * ClassName UserUpdateRequest
 * Description 用户修改信息
 * Author Lenovo
 * Date 2020/8/15
 * Version 1.0
 **/
@Data
@ApiModel("用户修改信息DTO")
public class UserUpdateRequest {

    @ApiModelProperty("用户Id")
    @NotNull(message = "用户Id为空")
    private Long userId;

    @ApiModelProperty("用户名")
    @NotNull(message = "用户名为空")
    private String userName;

    @ApiModelProperty("用户邮箱")
    @Email(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(.[a-zA-Z0-9_-]+)+$", message = "邮箱格式错误")
    @NotNull(message = "邮箱为空")
    private String userEmail;

    @ApiModelProperty("用户手机")
    @NotBlank(message = "用户手机为空")
    private String userPhone;

    @ApiModelProperty("用户状态")
    @NotNull(message = "状态为空")
    private Integer userStatus;

    @ApiModelProperty("用户类型")
    @NotNull(message = "类型为空")
    private Long roleType;

    @ApiModelProperty("用户部门")
    @NotNull(message = "用户部门为空")
    private Long deptIds;
}
