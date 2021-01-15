package com.codeworld.fc.goods.param.response;

import com.codeworld.fc.goods.param.entity.Param;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName ParamResponse
 * Description 参数列表Response
 * Author Lenovo
 * Date 2020/12/7
 * Version 1.0
**/
@Data
@ApiModel("参数列表Response")
public class ParamResponse extends Param {
    @ApiModelProperty("属性名称")
    private String attributeName;
}
