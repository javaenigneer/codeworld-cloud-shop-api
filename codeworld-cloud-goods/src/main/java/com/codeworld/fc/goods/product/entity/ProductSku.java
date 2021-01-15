package com.codeworld.fc.goods.product.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName ProductSku
 * Description 商品Sku
 * Author Lenovo
 * Date 2020/12/10
 * Version 1.0
 **/
@Data
@ApiModel("商品Sku")
public class ProductSku {

    @ApiModelProperty("商品Sku主键Id")
    private Long id;
    @ApiModelProperty("商品Id")
    private Long productId;
    @ApiModelProperty("商品Sku标题")
    private String title;
    @ApiModelProperty("商品Sku价格")
    private Integer price;
    @ApiModelProperty("商品Sku规格")
    private String ownSpec;
    @ApiModelProperty("商品图片")
    private String images;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
