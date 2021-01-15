package com.codeworld.fc.system.menu.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName MenuRequestDTO
 * Description 菜单修改信息
 * Author Lenovo
 * Date 2020/9/18
 * Version 1.0
**/
@Data
@ApiModel("菜单修改信息")
public class MenuRequestDTO {

    @ApiModelProperty("菜单Id")
    private Long id;

    @ApiModelProperty("上级Id")
    @NotNull(message = "父级Id为空")
    private Long parentId;

    @ApiModelProperty("菜单Url")
    @NotNull(message = "菜单URL为空")
    private String url;

    @ApiModelProperty("菜单名称")
    @NotNull(message = "菜单名称为空")
    private String title;

    @ApiModelProperty("菜单编码")
    @NotNull(message = "菜单编码为空")
    private String resources;

    @ApiModelProperty("类型")
    @NotNull(message = "菜单类型为空")
    private String type;

    @ApiModelProperty("菜单简介")
    private String remarks;

    @ApiModelProperty("排序")
    @NotNull(message = "菜单排序为空")
    private Integer sortNo;
}
