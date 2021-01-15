package com.codeworld.fc.system.menu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName Menu
 * Description 菜单Model
 * Author Lenovo
 * Date 2020/11/26
 * Version 1.0
**/
@Data
@ApiModel("菜单Model")
public class Menu {

    @ApiModelProperty("菜单Id")
    private Long id;

    @ApiModelProperty("上级Id")
    private Long parentId;

    @ApiModelProperty("菜单Url")
    private String url;

    @ApiModelProperty("菜单名称")
    private String title;

    @ApiModelProperty("菜单编码")
    private String resources;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("菜单简介")
    private String remarks;

    @ApiModelProperty("排序")
    private Integer sortNo;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm",timezone = "GTM+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:ss:mm",timezone = "GTM+8")
    private Date updateTime;
}
