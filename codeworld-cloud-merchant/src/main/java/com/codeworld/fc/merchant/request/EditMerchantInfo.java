package com.codeworld.fc.merchant.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName EditMerchantInfo
 * Description 更新商户信息Model
 * Author Lenovo
 * Date 2021/2/8
 * Version 1.0
**/
@Data
@ApiModel("更新商户信息Model")
public class EditMerchantInfo {

    @ApiModelProperty("商户号")
    private String number;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("商户跟进人")
    private Long merchantFollower;

}
