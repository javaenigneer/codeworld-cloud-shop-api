package com.codeworld.fc.goods.param.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName Param
 * Description 属性参数Model
 * Author Lenovo
 * Date 2020/12/7
 * Version 1.0
**/
@Data
@ApiModel("属性参数Model")
public class Param {

    @ApiModelProperty("参数主键Id")
    private Long id;
    @ApiModelProperty("属性名")
    private String name;
    @ApiModelProperty("特殊属性 1--是，0--不是")
    private Integer specialParam;
    @ApiModelProperty("属性Id")
    private Long attributeId;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
}
