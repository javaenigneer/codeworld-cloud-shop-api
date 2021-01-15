package com.codeworld.fc.goods.product.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName SkuVO
 * Description 商品添加SkuVO
 * Author Lenovo
 * Date 2020/12/14
 * Version 1.0
**/
@Data
@ApiModel("商品添加SkuVO")
public class SkuVO {

    @ApiModelProperty("颜色")
    private String color;

    @ApiModelProperty("规格")
    private String spec;

    @ApiModelProperty("价格")
    private Integer price;

    @ApiModelProperty("库存")
    private Integer stock;

    @ApiModelProperty("自身特有参数")
    private String ownSpec;

    @ApiModelProperty("商品图片")
    private String[] images;
}
