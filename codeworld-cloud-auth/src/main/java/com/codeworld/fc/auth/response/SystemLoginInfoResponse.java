package com.codeworld.fc.auth.response;

import com.codeworld.fc.auth.domain.ButtonVO;
import com.codeworld.fc.auth.domain.MenuVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Sets;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * ClassName SystemLoginInfoResponse
 * Description 系统登录用户信息
 * Author Lenovo
 * Date 2021/1/5
 * Version 1.0
**/
@Data
@ApiModel("系统登录用户信息")
public class SystemLoginInfoResponse {

    @ApiModelProperty("用户Id")
    private String id;

    @ApiModelProperty("登录Ip")
    private String loginIp;

    @ApiModelProperty("登录地址")
    private String loginLocation;

    @ApiModelProperty("登录时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;

    @ApiModelProperty("角色集")
    private Set<String> roles = Sets.newHashSet();

    @ApiModelProperty("菜单集")
    private Set<MenuVO> menus = Sets.newHashSet();

    @ApiModelProperty("按钮集")
    private Set<ButtonVO> buttons = Sets.newHashSet();
}
