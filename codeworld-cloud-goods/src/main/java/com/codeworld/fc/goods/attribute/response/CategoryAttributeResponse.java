package com.codeworld.fc.goods.attribute.response;

import com.codeworld.fc.goods.attribute.entity.CategoryAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName CategoryAttributeResponse
 * Description 分类属性Response
 * Author Lenovo
 * Date 2020/12/3
 * Version 1.0
**/
@Data
@ApiModel("商品分类属性Response")
public class CategoryAttributeResponse extends CategoryAttribute {

    @ApiModelProperty("分类名称")
    private String categoryName;
    @ApiModelProperty("属性数量")
    private Integer count;
}
