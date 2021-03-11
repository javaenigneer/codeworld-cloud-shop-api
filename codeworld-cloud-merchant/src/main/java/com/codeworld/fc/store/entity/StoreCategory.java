package com.codeworld.fc.store.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName StoreCategory
 * Description TODO
 * Author Lenovo
 * Date 2021/3/10
 * Version 1.0
**/
@Data
@ApiModel("店铺分类")
public class StoreCategory {

    @ApiModelProperty("店铺分类Id")
    private Long id;

    @ApiModelProperty("店铺Id")
    private Long storeId;

    @ApiModelProperty("分类父级Id")
    private Long parentId;

    @ApiModelProperty("分类名")
    private String name;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("排序")
    private Integer sortNo;
}
