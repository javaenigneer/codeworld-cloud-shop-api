package com.codeworld.fc.logistics.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName LogisticsInformation
 * Description TODO
 * Author Lenovo
 * Date 2021/3/5
 * Version 1.0
**/
@ApiModel("物流基本信息")
@Data
public class LogisticsInformation {

    @ApiModelProperty("物流单号")
    private String deliveryNumber;

    @ApiModelProperty("物流公司")
    private String deliveryCompany;


}
