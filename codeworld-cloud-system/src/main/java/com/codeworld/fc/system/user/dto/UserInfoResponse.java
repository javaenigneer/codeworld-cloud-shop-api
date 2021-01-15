package com.codeworld.fc.system.user.dto;


import com.codeworld.fc.system.user.vo.ButtonVO;
import com.codeworld.fc.system.user.vo.MenuVO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Sets;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * ClassName UserInfoResponse
 * Description 用户信息
 * Author Lenovo
 * Date 2020/11/4
 * Version 1.0
**/
@Data
@ApiModel("用户信息")
public class UserInfoResponse {

    @ApiModelProperty("用户Id")
    private Long userId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("用户邮箱")
    private String userEmail;

    @ApiModelProperty("用户状态")
    private Integer userStatus;

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
