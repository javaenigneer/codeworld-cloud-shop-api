package com.codeworld.fc.search.domain;

import com.codeworld.fc.common.base.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName ProductRequest
 * Description 商品列表信息搜索
 * Author Lenovo
 * Date 2020/11/28
 * Version 1.0
**/
@Data
@ApiModel("商品列表信息搜索")
public class ProductSearchRequest extends PageQuery {

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("商品状态")
    private Integer saleAble;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date updateTime;

    @ApiModelProperty("父级分类Id")
    private Long cateId;

    @ApiModelProperty("下级分类Id")
    private Long subCateId;

}
