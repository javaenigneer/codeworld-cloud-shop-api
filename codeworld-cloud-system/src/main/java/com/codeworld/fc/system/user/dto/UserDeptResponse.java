package com.codeworld.fc.system.user.dto;


import com.codeworld.fc.system.user.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * ClassName UserDeptResponse
 * Description 用户部门信息DTO
 * Author Lenovo
 * Date 2020/10/14
 * Version 1.0
**/
@Data
@ApiModel("用户部门信息DTO")
public class UserDeptResponse extends User {

    @ApiModelProperty("部门名称")
    private String deptName;
}
