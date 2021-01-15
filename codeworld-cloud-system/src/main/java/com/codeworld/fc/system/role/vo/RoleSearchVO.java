package com.codeworld.fc.system.role.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName RoleSearchVO
 * Description 角色搜索信息
 * Author Lenovo
 * Date 2020/9/18
 * Version 1.0
**/
@Data
@ApiModel("角色搜索信息")
public class RoleSearchVO {

    @ApiModelProperty("页数")
    private Integer page;

    @ApiModelProperty("数量")
    private Integer limit;

    @ApiModelProperty("角色名称")
    private String roleName;

}
