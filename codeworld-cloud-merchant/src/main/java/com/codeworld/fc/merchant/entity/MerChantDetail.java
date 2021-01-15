package com.codeworld.fc.merchant.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName MerChantDetail
 * Description 商户详细信息Model
 * Author Lenovo
 * Date 2020/12/30
 * Version 1.0
**/
@Data
@ApiModel("商户详细信息Model")
public class MerChantDetail {

    @ApiModelProperty("商户号")
    private String merchantNumber;

    @ApiModelProperty("商家名称")
    private String merchantName;

    @ApiModelProperty("身份证正面")
    private String idCardFront;

    @ApiModelProperty("身份证反面")
    private String idCardBack;

    @ApiModelProperty("营业执照")
    private String license;

    @ApiModelProperty("入住类型 1--包月 2--包季 3--包年")
    private Integer type;

    @ApiModelProperty("审核状态 1--审核成功， 审核失败")
    private Integer status;

    @ApiModelProperty("入驻时间")
    private Date createTime;
}
