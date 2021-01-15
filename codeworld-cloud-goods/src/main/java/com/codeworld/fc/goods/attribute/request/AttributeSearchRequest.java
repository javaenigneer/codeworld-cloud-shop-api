package com.codeworld.fc.goods.attribute.request;

import com.codeworld.fc.common.base.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * ClassName AttributeSearchRequest
 * Description 属性搜索Request
 * Author Lenovo
 * Date 2020/12/4
 * Version 1.0
**/
@Data
@ApiModel("属性搜索Request")
public class AttributeSearchRequest extends PageQuery {

    @ApiModelProperty("属性名")
    private String name;
    @ApiModelProperty("分类Id")
    @NotNull(message = "分类Id为空")
    private Long categoryId;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date updateTime;
}
