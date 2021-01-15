package com.codeworld.fc.system.role.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName RoleMenuRequest
 * Description 角色菜单信息
 * Author Lenovo
 * Date 2020/9/19
 * Version 1.0
**/
@Data
@ApiModel("角色菜单信息")
public class RoleMenuRequest {

    @ApiModelProperty("角色Id")
    @NotNull(message = "角色Id为空")
    private Long roleId;

    @ApiModelProperty("角色菜单")
    private String menuIds;
}
