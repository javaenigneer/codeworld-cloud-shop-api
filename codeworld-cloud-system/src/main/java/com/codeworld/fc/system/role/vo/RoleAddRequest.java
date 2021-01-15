package com.codeworld.fc.system.role.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName RoleUpdateRequest
 * Description 角色添加信息
 * Author Lenovo
 * Date 2020/9/19
 * Version 1.0
 **/
@Data
@ApiModel("角色添加信息")
public class RoleAddRequest {

    @ApiModelProperty("角色编码")
    @NotNull(message = "角色编码为空")
    private String roleCode;

    @ApiModelProperty("角色名称")
    @NotNull(message = "角色名称为空")
    private String roleName;

    @ApiModelProperty("角色描述")
    private String roleRemarks;
}
