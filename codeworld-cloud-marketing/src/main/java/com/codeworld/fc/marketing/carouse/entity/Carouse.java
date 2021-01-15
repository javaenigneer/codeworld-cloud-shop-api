package com.codeworld.fc.marketing.carouse.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName IndexCarouse
 * Description 首页轮播图
 * Author Lenovo
 * Date 2021/1/13
 * Version 1.0
**/
@Data
@ApiModel("首页轮播图")
public class Carouse {

    @ApiModelProperty("轮播图主键Id")
    private Long id;

    @ApiModelProperty("轮播图标题")
    private String title;

    @ApiModelProperty("轮播图图片")
    private String image;

    @ApiModelProperty("轮播图状态 0--未启用 1--已启用")
    private Integer status;

    @ApiModelProperty("开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;

    @ApiModelProperty("结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
