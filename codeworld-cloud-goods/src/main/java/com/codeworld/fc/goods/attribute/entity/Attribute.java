package com.codeworld.fc.goods.attribute.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName Attribute
 * Description 属性Model
 * Author Lenovo
 * Date 2020/12/4
 * Version 1.0
**/
@Data
@ApiModel("属性Model")
public class Attribute {

    @ApiModelProperty("属性主键Id")
    private Long id;
    @ApiModelProperty("属性名")
    private String name;
    @ApiModelProperty("分类Id")
    private Long categoryId;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
}
