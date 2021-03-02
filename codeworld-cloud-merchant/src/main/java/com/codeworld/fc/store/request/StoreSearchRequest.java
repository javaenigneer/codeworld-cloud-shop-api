package com.codeworld.fc.store.request;

import com.codeworld.fc.common.base.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * ClassName StoreSearchRequest
 * Description TODO
 * Author Lenovo
 * Date 2021/3/1
 * Version 1.0
**/
@Data
public class StoreSearchRequest extends PageQuery {

    /**
     * 商户号
     */
    private String merchantNumber;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
