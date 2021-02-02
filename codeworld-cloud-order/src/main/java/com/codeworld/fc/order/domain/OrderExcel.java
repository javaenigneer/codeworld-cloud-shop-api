package com.codeworld.fc.order.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName OrderExcel
 * Description 订单数据导出信息
 * Author Lenovo
 * Date 2021/2/2
 * Version 1.0
**/
@Data
@ApiModel("订单数据导出信息")
public class OrderExcel {

    @ApiModelProperty("订单编号")
    private Long orderId;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("买家名称")
    private String buyerName;

    @ApiModelProperty("订单总金额")
    private Long totalPay;

    @ApiModelProperty("订单状态")
    private Integer orderStatus;

    /**
     * 得到所有变量填充的数组
     */
    public Object[] getFieldArray()
    {
        /*定义先关变量*/
        //创建列表
        List<String> FieldList = new ArrayList<String>();

        /*向列表中添加数据*/
        FieldList.add(orderId.toString());
        FieldList.add(createTime.toString());
        FieldList.add(buyerName);
        FieldList.add(totalPay.toString());
        FieldList.add(orderStatus.toString());

        /*返回数据*/
        return FieldList.toArray();
    }
}
