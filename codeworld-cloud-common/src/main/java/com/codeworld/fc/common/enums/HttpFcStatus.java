package com.codeworld.fc.common.enums;
/**
 * ClassName HttpFcStatus
 * Description 状态枚举类
 * Author Lenovo
 * Date 2020/10/29
 * Version 1.0
**/
public enum  HttpFcStatus {

    /**
     * 系统错误
     */
    RUNTIMECODE(20001),

    /**
     * 验证错误
     */
    VALIDATEFAILCODE(20002),

    /**
     * 验证成功
     */
    VALIDATESUCCESSCODE(10002),

    /**
     * 认证错误
     */
    AUTHFAILCODE(20003),

    /**
     * 认证成功
     */
    AUTHSUCCESSCODE(10003),

    /**
     * 数据请求成功
     */
    DATASUCCESSGET(20000),

    /**
     * 参数错误
     */
    PARAMSERROR(40001),


    /**
     * 数据存在
     */
    DATAEXIST(40000),

    /**
     * 数据为空
     */
    DATAEMPTY(20004),


    ;

    private Integer code;

    HttpFcStatus(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
