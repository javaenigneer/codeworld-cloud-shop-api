package com.codeworld.fc.goods.product.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * ClassName ExamineProductRequest
 * Author Lenovo
**/
@Data
@ApiModel("商品审核请求信息")
public class ExamineProductRequest {

    @NotNull(message = "商品Id为空")
    private Long productId;

    @NotNull(message = "状态为空")
    private Integer approveStatus;

    @NotBlank(message = "审核信息为空")
    private String approveRemark;
}
