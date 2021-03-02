package com.codeworld.fc.store.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName Store
 * Description TODO
 * Author Lenovo
 * Date 2021/3/1
 * Version 1.0
**/
@Data
@ApiModel("店铺")
public class Store {

    @ApiModelProperty("店铺Id")
    private Long id;

    @ApiModelProperty("店铺名")
    private String name;

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    @ApiModelProperty("商户号")
    private String merchantNumber;
}
