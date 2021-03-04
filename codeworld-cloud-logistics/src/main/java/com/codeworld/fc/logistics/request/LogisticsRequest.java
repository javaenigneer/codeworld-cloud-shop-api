package com.codeworld.fc.logistics.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * ClassName LogisticsRequest
 * Description TODO
 * Author Lenovo
 * Date 2021/3/4
 * Version 1.0
**/
@Data
public class LogisticsRequest {

    /**
     * 物流单号
     */
    @NotNull(message = "物流单号为空")
    private String deliveryNumber;

    /**
     * 物流编号
     */
    @NotNull(message = "物流编号为空")
    private Integer deliverySn;

    /**
     * 订单号
     */
    @NotNull(message = "订单号为空")
    private Long orderId;

    /**
     * 物流更新内容
     */
    @NotNull(message = "物流更新内容为空")
    private String content;
}
