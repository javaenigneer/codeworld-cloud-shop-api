package com.codeworld.fc.system.dept.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName DeptRequestDTO
 * Description 部门添加修改信息
 * Author Lenovo
 * Date 2020/10/13
 * Version 1.0
**/
@Data
@ApiModel("部门添加修改信息")
public class DeptRequestDTO {

    @ApiModelProperty("部门主键Id")
    private Long id;

    @ApiModelProperty("上级部门Id")
    @NotNull(message = "上级部门Id为空")
    private Long parentId;

    @ApiModelProperty("部门名称")
    @NotNull(message = "部门名称为空")
    private String title;

    @ApiModelProperty("部门简介")
    @NotNull(message = "部门简介为空")
    private String remarks;

    @ApiModelProperty("排序")
    @NotNull(message = "部门排序为空")
    private Integer sortNo;
}
