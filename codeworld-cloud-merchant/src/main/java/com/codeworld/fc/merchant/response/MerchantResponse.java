package com.codeworld.fc.merchant.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * ClassName MerchantResponse
 * Description 商户信息Response
 * Author Lenovo
 * Date 2020/12/31
 * Version 1.0
**/
@Data
@ApiModel("商户信息Response")
public class MerchantResponse {

    @ApiModelProperty("商户主键Id")
    private Long id;

    @ApiModelProperty("商户号")
    private String number;

    @ApiModelProperty("商户昵称")
    private String nickName;

    @ApiModelProperty("商户密码")
    private String password;

    @ApiModelProperty("商户手机号")
    private String phone;

    @ApiModelProperty("商户状态，是否入驻")
    private Integer status;

    @ApiModelProperty("加入时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty("商户名称")
    private String merchantName;

    @ApiModelProperty("身份证正面")
    private String idCardFront;

    @ApiModelProperty("身份证背面")
    private String idCardBack;

    @ApiModelProperty("营业执照")
    private String license;

    @ApiModelProperty("入驻类型")
    private Integer type;

    @ApiModelProperty("入驻时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date setCreateTime;

    @ApiModelProperty("商户跟进人")
    private String merchantFollower;

    @ApiModelProperty("跟进人Id")
    private Long followerId;

    @ApiModelProperty("头像")
    private String avatar;

}
