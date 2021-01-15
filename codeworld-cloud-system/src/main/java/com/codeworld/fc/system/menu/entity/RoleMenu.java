package com.codeworld.fc.system.menu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName RoleMenu
 * Description 角色菜单类
 * Author Lenovo
 * Date 2020/9/14
 * Version 1.0
**/
@Data
@ApiModel("角色菜单类")
public class RoleMenu {

    @ApiModelProperty("角色菜单主键Id")
    private Long roleMenuId;

    @ApiModelProperty("角色Id")
    private Long roleId;

    @ApiModelProperty("菜单Id")
    private Long menuId;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm",timezone = "GTM+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm",timezone = "GTM+8")
    private Date updateTime;
}

