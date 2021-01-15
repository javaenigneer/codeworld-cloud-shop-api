package com.codeworld.fc.goods.category.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName CategoryRequest
 * Description 分类请求数据Model
 * Author Lenovo
 * Date 2020/11/27
 * Version 1.0
**/
@Data
@ApiModel("分类请求数据Model")
public class CategoryRequest {

    @ApiModelProperty("分类Id")
    private Long id;

    @ApiModelProperty("上级Id")
    @NotNull(message = "父级Id为空")
    private Long parentId;


    @ApiModelProperty("分类名称")
    @NotNull(message = "分类名称为空")
    private String name;

    @ApiModelProperty("类型")
    @NotNull(message = "分类类型为空")
    private String type;

    @ApiModelProperty("排序")
    @NotNull(message = "菜单排序为空")
    private Integer sortNo;

    @ApiModelProperty("分类图片")
    @NotNull(message = "分类图片为空")
    private String image;
}
