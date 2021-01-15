package com.codeworld.fc.system.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName UserDept
 * Description 用户部门
 * Author Lenovo
 * Date 2020/10/14
 * Version 1.0
**/
@Data
@ApiModel("用户部门")
public class UserDept {

    @ApiModelProperty("用户部门主键Id")
    private Long userDeptId;

    @ApiModelProperty("用户Id")
    private Long userId;

    @ApiModelProperty("部门Id")
    private Long deptId;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;


}
