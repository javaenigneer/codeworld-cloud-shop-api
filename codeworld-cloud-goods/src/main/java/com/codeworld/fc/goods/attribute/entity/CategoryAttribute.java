package com.codeworld.fc.goods.attribute.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName CategoryAttribute
 * Description 分类属性Model
 * Author Lenovo
 * Date 2020/12/3
 * Version 1.0
**/
@Data
@ApiModel("分类属性Model")
public class CategoryAttribute {

    @ApiModelProperty("分类属性id")
    private Long id;
    @ApiModelProperty("分类id")
    private Long categoryId;
    @ApiModelProperty("属性id")
    private Long attributeId;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

}
