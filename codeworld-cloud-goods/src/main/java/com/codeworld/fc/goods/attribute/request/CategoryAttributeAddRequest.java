package com.codeworld.fc.goods.attribute.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * ClassName CategoryAttributeAddRequest
 * Description 分类属性添加Request
 * Author Lenovo
 * Date 2020/12/3
 * Version 1.0
**/
@Data
@ApiModel("分类属性添加Request")
public class CategoryAttributeAddRequest {

    @ApiModelProperty("分类Id")
    @NotNull(message = "请选择分类")
    private Long categoryId;
    @ApiModelProperty("备注")
    @NotNull(message = "请至少设置一个属性")
    private List<String> attributes;
}
