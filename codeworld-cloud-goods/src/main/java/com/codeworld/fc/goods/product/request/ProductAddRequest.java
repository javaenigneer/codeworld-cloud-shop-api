package com.codeworld.fc.goods.product.request;

import com.codeworld.fc.goods.category.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * ClassName ProductAddRequest
 * Description 商品添加信息
 * Author Lenovo
 * Date 2020/11/30
 * Version 1.0
**/
@Data
@ApiModel("商品添加信息")
public class ProductAddRequest {
    @ApiModelProperty("商品标题")
    @NotNull(message = "商品标题为空")
    private String title;

    @ApiModelProperty("商品分类")
    @NotNull(message = "商品分类为空")
    private Long categoryId;

    @ApiModelProperty("包装清单")
    @NotNull(message = "请输入包装清单")
    private String packingList;

    @ApiModelProperty("售后服务")
    @NotNull(message = "请输入售后服务")
    private String afterService;

    @ApiModelProperty("商品描述")
    @NotNull(message = "请输入商品描述")
    private String desc;

    @ApiModelProperty("通用参数")
    @NotNull(message = "信息不完整--通用参数")
    private String genericParam;

    @ApiModelProperty("特殊参数")
    @NotNull(message = "信息不完整--特殊参数")
    private String specialParam;

    @ApiModelProperty("商品Sku")
    @NotNull(message = "信息不完整--Sku")
    private String sku;

}
