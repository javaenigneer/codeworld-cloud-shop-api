package com.codeworld.fc.marketing.carouse.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * ClassName CarouseAddReqeust
 * Description 轮播图添加Request
 * Author Lenovo
 * Date 2021/1/13
 * Version 1.0
**/
@Data
@ApiModel("轮播图添加Request")
public class CarouseAddRequest {

    @ApiModelProperty("标题")
    @NotNull(message = "请输入标题")
    private String title;

    @ApiModelProperty("开始时间")
    @NotNull(message = "请选择开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;

    @ApiModelProperty("结束时间")
    @NotNull(message = "请选择结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    @ApiModelProperty("状态")
    @NotNull(message = "请选择状态")
    private Integer status;

    @ApiModelProperty("图片")
    @NotNull(message = "请上传图片")
    private String image;

    @ApiModelProperty("轮播图位置 1--app首页 2--店铺")
    @NotNull(message = "请选择轮播图位置")
    private Integer position;
}
