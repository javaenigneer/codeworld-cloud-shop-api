package com.codeworld.fc.goods.param.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ClassName ParamAddReqeust
 * Description 添加参数Request
 * Author Lenovo
 * Date 2020/12/7
 * Version 1.0
**/
@Data
@ApiModel("添加参数Request")
public class ParamAddRequest {

    @ApiModelProperty("参数名称")
    @NotNull(message = "请输入参数名称")
    private String name;
    @ApiModelProperty("属性Id")
    @NotNull(message = "属性Id为空")
    private Long attributeId;
    @ApiModelProperty("特殊参数")
    @NotNull(message = "请选择状态")
    private Integer specialParam;
}
