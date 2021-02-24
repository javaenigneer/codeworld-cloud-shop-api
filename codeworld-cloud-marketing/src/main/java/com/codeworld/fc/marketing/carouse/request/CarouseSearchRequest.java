package com.codeworld.fc.marketing.carouse.request;

import com.codeworld.fc.common.base.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * ClassName CarouseSearchRequest
 * Description 轮播图搜索Request
 * Author Lenovo
 * Date 2021/1/13
 * Version 1.0
**/
@Data
@ApiModel("轮播图搜索Request")
public class CarouseSearchRequest extends PageQuery {

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @ApiModelProperty("结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @ApiModelProperty("商户号")
    private String merchantNumber;
}
