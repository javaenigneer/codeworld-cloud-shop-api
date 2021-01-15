package com.codeworld.fc.goods.param.request;

import com.codeworld.fc.common.base.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * ClassName ParamSearchRequest
 * Description 参数搜索Request
 * Author Lenovo
 * Date 2020/12/7
 * Version 1.0
**/
@Data
@ApiModel("参数搜索Request")
public class ParamSearchRequest extends PageQuery {

    @ApiModelProperty("属性Id")
    @NotNull(message = "属性为空")
    private Long attributeId;
    @ApiModelProperty("参数名称")
    private String name;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date updateTime;
}
