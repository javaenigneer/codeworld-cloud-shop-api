package com.codeworld.fc.common.response;

import com.codeworld.fc.common.enums.HttpFcStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName FCResponse
 * Description 请求数据响应
 * Author Lenovo
 * Date 2020/11/26
 * Version 1.0
**/
@Data
public class FCResponse<T> implements Serializable {
    /**
     *状态码
     */
    private Integer code;


    /**
     * 响应信息
     */
    private String msg;


    /**
     * 响应数据
     */
    private T data;

    public FCResponse() { }

    public FCResponse(Integer code, String msg, T data){

        this.code = code;

        this.msg = msg;

        this.data = data;
    }

    public FCResponse(Integer code, String msg){

        this.code = code;

        this.msg = msg;
    }

    /**
     * 系统错误
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> FCResponse<T> runtimeResponse(String msg){

        return new FCResponse<>(HttpFcStatus.RUNTIMECODE.getCode(),msg);
    }

    /**
     * 认证错误
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> FCResponse<T> authErrorResponse(String msg){

        return new FCResponse<>(HttpFcStatus.AUTHFAILCODE.getCode(),msg);
    }

    /**
     * 数据响应--无数据
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> FCResponse<T> dataResponse(Integer code, String msg){

        return new FCResponse<>(code, msg);
    }

    /**
     * 数据响应--带数据
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> FCResponse<T> dataResponse(Integer code, String msg, T data){

        return new FCResponse<>(code, msg, data);
    }


    /**
     * 参数校验失败
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> FCResponse<T> validateErrorResponse(String msg){

        return new FCResponse<>(HttpFcStatus.PARAMSERROR.getCode(), msg);
    }


}
