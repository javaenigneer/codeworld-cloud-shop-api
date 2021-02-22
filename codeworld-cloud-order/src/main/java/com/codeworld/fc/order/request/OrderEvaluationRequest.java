package com.codeworld.fc.order.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * ClassName OrderEvaluationRequest
 * Description TODO
 * Author Lenovo
 * Date 2021/2/22
 * Version 1.0
**/
@Data
@ApiModel("订单商品评价Request")
public class OrderEvaluationRequest {

    @ApiModelProperty("订单商品评价内容")
    @NotNull(message = "评价内容不能为空")
    private String evaluationContent;

    @ApiModelProperty("订单商品评价图片")
    private List<String> evaluationImages;

    @ApiModelProperty("评分")
    private Integer evaluationRate;

    @ApiModelProperty("订单详细Id")
    @NotNull(message = "订单详细Id不能为空")
    private Long orderDetailId;


}
