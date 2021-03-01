package com.codeworld.fc.merchant.request;

import com.codeworld.fc.common.base.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName MerchantSearchRequest
 * Description 商户搜索Request
 * Author Lenovo
 * Date 2021/1/4
 * Version 1.0
**/
@Data
@ApiModel("商户搜索Request")
public class MerchantSearchRequest extends PageQuery {

    @ApiModelProperty("商户昵称")
    private String nickName;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date createTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date updateTime;

    @ApiModelProperty("商户跟进人")
    private Long merchantFollowUser;

    @ApiModelProperty("入驻时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date settlementTime;

}
