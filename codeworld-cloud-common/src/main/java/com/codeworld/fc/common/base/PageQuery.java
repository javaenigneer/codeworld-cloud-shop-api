package com.codeworld.fc.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName PageQuery
 * Description 分页信息
 * Author Lenovo
 * Date 2020/11/26
 * Version 1.0
**/
@Data
@ApiModel("分页信息")
public class PageQuery {

    @ApiModelProperty("页数")
    private Integer page;

    @ApiModelProperty("数量")
    private Integer limit;
}
