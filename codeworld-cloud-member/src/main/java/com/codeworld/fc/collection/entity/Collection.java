package com.codeworld.fc.collection.entity;

import com.codeworld.fc.collection.service.CollectionService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * ClassName Collection
 * Description TODO
 * Author Lenovo
 * Date 2021/3/8
 * Version 1.0
**/
@Data
@ApiModel("商品收藏Model")
public class Collection {

    @ApiModelProperty("收藏主键Id")
    private Long id;

    @ApiModelProperty("商品Id")
    private Long productId;

    @ApiModelProperty("商品SkuId")
    private Long productSkuId;

    @ApiModelProperty("会员Id")
    private Long memberId;

    @ApiModelProperty("收藏时间")
    private Date collectionTime;

    @ApiModelProperty("商品图片")
    private String image;

    @ApiModelProperty("商品单价")
    private Integer price;

    @ApiModelProperty("商品标题")
    private String title;

}
