package com.codeworld.fc.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName DataResponse
 * Description TODO
 * Author Lenovo
 * Date 2020/9/21
 * Version 1.0
**/
@Data
@ApiModel("数据响应信息")
public class DataResponse<T> implements Serializable {

    @ApiModelProperty("数据")
    private T data;

    @ApiModelProperty("总数")
    private Long total;

    public DataResponse() {
    }

    public DataResponse(T data, Long total) {
        this.data = data;
        this.total = total;
    }

    /**
     * 数据响应
     * @param <T>
     * @return
     */
    public static <T> DataResponse<T> dataResponse(T data, Long total){

        return new DataResponse<>(data, total);
    }

}
