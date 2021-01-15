package com.codeworld.fc.system.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName ButtonVO
 * Description 按钮
 * Author Lenovo
 * Date 2020/9/14
 * Version 1.0
**/
@Data
@ApiModel("按钮")
public class ButtonVO {

    @ApiModelProperty("主键Id")
    private Integer id;

    @ApiModelProperty("上级按钮Id")
    private String parentId;

    @ApiModelProperty("按钮编码")
    private String resources;

    @ApiModelProperty("按钮名称")
    private String title;

    @ApiModelProperty("类型")
    private String type;

//    @ApiModelProperty("按钮图标")
//    private String icon;
}
