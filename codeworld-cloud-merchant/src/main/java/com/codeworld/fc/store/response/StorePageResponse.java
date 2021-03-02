package com.codeworld.fc.store.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName StorePageResponse
 * Description TODO
 * Author Lenovo
 * Date 2021/3/1
 * Version 1.0
**/
@Data
public class StorePageResponse {

    @ApiModelProperty("店铺Id")
    private Long storeId;

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

}
