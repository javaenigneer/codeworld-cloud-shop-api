package com.codeworld.fc.goods.attribute.request;

import com.codeworld.fc.common.base.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName CategoryAttributeSearchRequest
 * Description 分类属性搜索
 * Author Lenovo
 * Date 2020/12/3
 * Version 1.0
**/
@Data
@ApiModel("分类属性搜索")
public class CategoryAttributeSearchRequest extends PageQuery {

    @ApiModelProperty("分类Id")
    private Long categoryId;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date updateTime;
}
