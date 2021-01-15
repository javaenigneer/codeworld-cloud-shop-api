package com.codeworld.fc.search.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ClassName ProductSearchRequest
 * Description app首页默认搜索Request
 * Author Lenovo
 * Date 2020/12/17
 * Version 1.0
**/
@Data
@ApiModel("首页默认搜索Request")
public class ProductIndexSearchRequest {

    @ApiModelProperty("起始页")
    private Integer pageFrom;
    @ApiModelProperty("数量")
    private Integer pageSize;

}
