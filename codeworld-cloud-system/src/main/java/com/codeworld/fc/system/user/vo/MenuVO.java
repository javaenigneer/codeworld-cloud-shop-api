package com.codeworld.fc.system.user.vo;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * ClassName MenuVO
 * Description 菜单VO
 * Author Lenovo
 * Date 2020/9/16
 * Version 1.0
 **/
@Data
@ApiModel("菜单VO")
public class MenuVO {

    @ApiModelProperty("菜单Id")
    private Integer id;

    @ApiModelProperty("上级菜单Id")
    private String parentId;

    @ApiModelProperty("菜单编码")
    private String resources;

    @ApiModelProperty("菜单名称")
    private String title;

    @ApiModelProperty("类型")
    private String type;

//    @ApiModelProperty("菜单图标")
//    private String icon;

    List<MenuVO> children = Lists.newArrayList();
}
