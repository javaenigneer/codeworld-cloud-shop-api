package com.codeworld.fc.system.area.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName Area
 * Description 区域Model
 * Author Lenovo
 * Date 2021/1/29
 * Version 1.0
**/
@Data
@ApiModel("区域Model")
public class Area {

    @ApiModelProperty("区域Id")
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("父级Id")
    private Long parentId;

    @ApiModelProperty("排序")
    private Integer sortNo;
}
