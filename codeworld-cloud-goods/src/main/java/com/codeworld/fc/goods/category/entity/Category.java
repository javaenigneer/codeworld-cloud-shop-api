package com.codeworld.fc.goods.category.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName Category
 * Description 分类Model
 * Author Lenovo
 * Date 2020/11/27
 * Version 1.0
**/
@Data
@ApiModel("分类Model")
public class Category {

    @ApiModelProperty("分类主键Id")
    private Long id;
    @ApiModelProperty("分类名称")
    private String name;
    @ApiModelProperty("父级Id")
    private Long parentId;
    @ApiModelProperty("排序")
    private Integer sortNo;
    @ApiModelProperty("类型")
    private String type;
    @ApiModelProperty("分类图片")
    private String image;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
