package com.codeworld.fc.goods.attribute.response;

import com.codeworld.fc.goods.attribute.entity.Attribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName AttributeResponse
 * Description 属性数据返回Model
 * Author Lenovo
 * Date 2020/12/4
 * Version 1.0
**/
@Data
@ApiModel("属性数据返回Model")
public class AttributeResponse extends Attribute {

    @ApiModelProperty("分类名")
    private String categoryName;
    @ApiModelProperty("参数个数")
    private Integer count ;
}
