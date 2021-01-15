package com.codeworld.fc.goods.attribute.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName AttributeAddRequest
 * Description 属性添加Request
 * Author Lenovo
 * Date 2020/12/4
 * Version 1.0
**/
@Data
@ApiModel("属性添加Request")
public class AttributeAddRequest {

    @ApiModelProperty("分类Id")
    @NotNull(message = "分类Id为空")
    private Long categoryId;
    @ApiModelProperty("属性名称")
    @NotNull(message = "请输入属性名")
    private String name;
}
