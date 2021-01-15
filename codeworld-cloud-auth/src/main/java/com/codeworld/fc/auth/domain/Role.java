package com.codeworld.fc.auth.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName Role
 * Description 角色基本类
 * Author Lenovo
 * Date 2020/11/5
 * Version 1.0
**/
@Data
@ApiModel("角色基本类")
public class Role {

    @ApiModelProperty("角色主键Id")
    private Long roleId;

    @ApiModelProperty("角色编码")
    private String roleCode;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("角色描述")
    private String roleRemarks;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm",timezone = "GTM+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm",timezone = "GTM+8")
    private Date updateTime;
}
