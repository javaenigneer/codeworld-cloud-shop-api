package com.codeworld.fc.common.enums;

/**
 * 响应信息
 */
public class HttpMsg {


    /**
     * 用户相关
     */
    public enum user {

        USER_STATUS_SUCCESS("用户状态修改成功"),

        USER_DELETE_SUCCESS("用户删除成功"),

        USER_ID_ERROR("用户ID错误"),

        USER_LOGIN_SUCCESS("登录成功"),

        USER_LOGIN_ERROR("用户未登录"),

        USER_AUTH_SUCCESS("认证成功"),

        USER_AUTH_ERROR("认证失败"),

        USER_ADD_SUCCESS("用户添加成功"),

        USER_EXIST("用户名存在"),

        USER_NO_EXIST("用户不存在"),

        USER_NAME_RIGHT("用户名可用"),

        USER_UPDATE_SUCCESS("用户信息修改成功"),

        USER_DISABLE("用户被禁用"),

        USER_LOGIN_OUT_SUCCESS("登出成功"),

        USE_DATA_EMPTY("用户数据为空"),

        USER_GET_SUCCESS("用户数据查询成功"),
        USER_NAME_ERROR("用户名错误"),
        USER_MESSAGE_ERROR("用户名或密码错误");

        private String msg;

        user(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 菜单相关
     */
    public enum menu {

        MENU_GET_SUCCESS("菜单查询成功"),

        MENU_UPDATE_SUCCESS("菜单修改成功"),

        MENU_ADD_SUCCESS("菜单添加成功"),

        MENU_DELETE_SUCCESS("菜单删除成功"),

        MENU_PARAM_ERROR("参数错误"),
        MENU_DATA_EMPTY("菜单数据为空");

        private String msg;

        menu(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 角色相关
     */
    public enum role {

        ROLE_DATA_EMPTY("角色数据为空"),

        ROLE_DATA_SUCCESS("角色查询成功"),

        ROLE_PARAM_ERROR("角色参数错误"),

        ROLE_MENU_DATA_SUCCESS("角色菜单查询成功"),

        ROLE_UPDATE_SUCCESS("角色修改成功"),

        ROLE_MENU_ADD_SUCCESS("角色菜单设置成功"),

        ROLE_ADD_SUCCESS("角色添加成功"),

        ROLE_DELETE_SUCCESS("角色删除成功");

        private String msg;

        role(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 日志相关
     */
    public enum log {

        LOG_DATA_SUCCESS("日志查询成功"),

        LOG_DATA_EMPTY("日志数据为空"),

        LOG_PARAM_ERROR("日志参数错误"),

        LOG_DELETE_SUCCESS("日志删除成功");

        private String msg;

        log(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }


    /**
     * 请求追踪相关
     */
    public enum http {

        HTTP_DATA_SUCCESS("任务日志查询成功");

        private String msg;

        http(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }


    /**
     * 部门相关
     */
    public enum dept {

        DEPT_GET_SUCCESS("部门查询成功"),

        DEPT_UPDATE_SUCCESS("部门修改成功"),

        DEPT_ADD_SUCCESS("部门添加成功"),

        DEPT_DELETE_SUCCESS("部门删除成功"),

        DEPT_PARAM_ERROR("参数错误");

        private String msg;

        dept(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }


    /**
     * 分类相关
     */
    public enum category {

        CATEGORY_GET_SUCCESS("分类查询成功"),
        CATEGORY_ADD_SUCCESS("分类添加成功"),
        CATEGORY_UPDATE_SUCCESS("分类修改成功"),
        CATEGORY_DATA_EMPTY("分类数据为空"),
        CATEGORY_ID_ERROR("分类ID错误"),
        CATEGORY_ATTRIBUTE_SET("该分类已设置属性"),
        CATEGORY_BIND_PRODUCT("该分类已关联商品");

        private String msg;

        category(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 商品相关
     */
    public enum product {
        PRODUCT_DATA_EMPTY("商品数据为空"),
        PRODUCT_GET_SUCCESS("商品数据查询成功"),
        PRODUCT_ID_ERROR("商品ID错误"),
        PRODUCT_UPDATE_STATUS("商品状态修改成功"),
        PRODUCT_ADD_SUCCESS("商品添加成功"),
        PRODUCT_PARAM_ERROR("商品参数错误"),
        PRODUCT_IMPORT_SUCCESS("商品导入成功"),
        PRODUCT_DELETE_ELASTICSEARCH("商品索引库已清空");

        private String msg;

        product(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 图片
     */
    public enum image {

        IMAGE_FORMAT_ERROR("图片格式错误"),

        IMAGE_UPLOAD_ERROR("图片上传失败"),

        IMAGE_UPLOAD_SUCCESS("图片上传成功");

        image(String msg) {
            this.msg = msg;
        }

        private String msg;

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 分类属性
     */
    public enum categoryAttribute {

        CATEGORY_ATTRIBUTE_DATA_EMPTY("分类属性数据为空"),
        CATEGORY_ATTRIBUTE_GET_SUCCESS("分类属性查询成功"),
        CATEGORY_ATTRIBUTE_ADD_SUCCESS("分类属性添加成功"),
        CATEGORY_ATTRIBUTE_DATA_REPEAT("属性重复"),
        CATEGORY_ATTRIBUTE_ADD_ATTRIBUTE("请设置属性");

        categoryAttribute(String msg) {
            this.msg = msg;
        }

        private String msg;

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 分类属性
     */
    public enum attribute {

        ATTRIBUTE_DATA_EMPTY("属性数据为空"),
        ATTRIBUTE_GET_SUCCESS("属性查询成功"),
        ATTRIBUTE_ADD_SUCCESS("属性添加成功");

        attribute(String msg) {
            this.msg = msg;
        }

        private String msg;

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 参数
     */
    public enum param {

        PARAM_DATA_EMPTY("参数数据为空"),
        PARAM_GET_SUCCESS("参数查询成功"),
        PARAM_ADD_SUCCESS("参数添加成功"),
        PARAM_GENERIC_DATA_EMPTY("通用参数数据为空");

        param(String msg) {
            this.msg = msg;
        }

        private String msg;

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 短信
     */
    public enum sms {
        SMS_PHONE_ERROR("号码格式错误"),
        SMS_PHONE_SUCCESS("短信发送成功"),
        SMS_CODE_ERROR("验证码错误"),
        SMS_CODE_EXPIRE("验证码已过期");

        sms(String msg) {
            this.msg = msg;
        }

        ;

        private String msg;

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 会员
     */
    public enum member {
        MEMBER_REGISTER_SUCCESS("会员注册成功"),
        MEMBER_DATA_SUCCESS("会员查询成功"),
        MEMBER_NOT_REGISTER("该手机号未注册"),
        MEMBER_MESSAGE_ERROR("会员名或密码错误"),
        MEMBER_LOGIN_SUCCESS("会员登录成功"),
        MEMBER_DATA_EXPIRE("身份已过期，请重新登录"),
        MEMBER_ID_ERROR("会员Id错误"),
        MEMBER_DATA_EMPTY("会员信息为空"),
        MEMBER_PHONE_REGISTER("该手机号已注册");

        member(String msg) {
            this.msg = msg;
        }

        ;

        private String msg;

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 地址
     */
    public enum address {
        ADDRESS_ADD_SUCCESS("地址添加成功"),
        ADDRESS_ID_ERROR("地址ID错误"),
        ADDRESS_UPDATE_SUCCESS("地址修改成功"),
        ADDRESS_DATA_SUCCESS("地址查询成功"),
        ADDRESS_DATA_EMPTY("地址信息为空");

        address(String msg) {
            this.msg = msg;
        }

        ;
        private String msg;

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 购物车
     */
    public enum cart {
        CART_DATA_EMPTY("购物车为空"),
        CART_DATA_SUCCESS("购物车查询成功"),
        CART_ADD_SUCCESS("购物车添加成功"),
        CART_ID_ERROR("购物车ID错误"),
        CART_DELETE_SUCCESS("购物车删除成功");

        cart(String msg) {
            this.msg = msg;
        }

        ;
        private String msg;

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 订单
     */
    public enum order {
        ORDER_CREATE_SUCCESS("订单创建成功"),
        ORDER_DATA_EMPTY("订单数据为空"),
        ORDER_DATA_SUCCESS("订单查询成功"),
        ORDER_PAY_SUCCESS("订单支付成功"),
        ORDER_MONEY_ERROR("订单金额错误"),
        ORDER_ID_ERROR("订单ID无效"),
        ORDER_STATUS_ERROR("订单状态错误"),
        ORDER_RETURN_APPLY_SUCCESS("订单售后申请成功"),
        ORDER_EXPORT_SUCCESS("订单数据导出成功"),
        ORDER_CANCEL_SUCCESS("订单取消成功"),
        ORDER_CONFIRM_RECEIPT_SUCCESS("订单收货成功")
        ;

        order(String msg) {
            this.msg = msg;
        }

        ;
        private String msg;

        public String getMsg() {
            return msg;
        }
    }


    /**
     * 商户
     */
    public enum merchant {
        MERCHANT_ADD_SUCCESS("商户注册成功"),
        MERCHANT_DATA_SUCCESS("商户数据查询成功"),
        MERCHANT_MESSAGE_ERROR("手机号或密码错误"),
        MERCHANT_SETTLED_ADD_SUCCESS("商户入驻提交成功"),
        MERCHANT_LOGIN_SUCCESS("商户登录成功"),
        MERCHANT_EXIST("商户审核通过或正在审核中"),
        MERCHANT_DATA_EMPTY("商户数据为空"),
        MERCHANT_ID_ERROR("商户ID错误"),
        MERCHANT_NUMBER_ERROR("商户号错误"),
        MERCHANT_EXAMINE_SUCCESS("审核成功"),
        MERCHANT_NO_REGISTER("该商户未注册"),
        MERCHANT_PHONE_REGISTER("该手机号已注册"),
        MERCHANT_LOGIN_EXPIRE("商户登录失效"),
        MERCHANT_DATA_UPDATE_SUCCESS("商户更新成功")
        ;

        merchant(String msg) {
            this.msg = msg;
        }

        ;
        private String msg;

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 轮播图
     */
    public enum carouse {
        CAROUSE_DATA_EMPTY("轮播图数据为空"),
        CAROUSE_DATA_SUCCESS("轮播图数据查询成功"),
        CAROUSE_ADD_SUCCESS("轮播图添加成功"),
        CAROUSE_END_DATE_ERROR("结束时间不能小于开始时间"),
        CAROUSE_DATE_ERROR("开始时间或结束时间不能小于当前时间");

        carouse(String msg) {
            this.msg = msg;
        }

        ;
        private String msg;

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 物流
     */
    public enum delivery {
        DELIVERY_SN_ERROR("物流编号错误"),
        DELIVERY_ORDER_SUCCESS("订单发货成功");

        delivery(String msg) {
            this.msg = msg;
        }

        ;
        private String msg;

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 地区
     */
    public enum area {
        AREA_GET_SUCCESS("地区查询成功");

        area(String msg) {
            this.msg = msg;
        }

        ;
        private String msg;

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 服务订单
     */
    public enum orderReturn {

        ORDER_RETURN_ID_ERROR("服务订单号错误"),
        ORDER_RETURN_DATA_EMPTY("服务订单数据为空"),
        ORDER_RETURN_PROCESSED("服务订单已被处理"),
        ORDER_RETURN_ACCPECTED_SUCCESS("服务订单受理成功")
        ;

        orderReturn(String msg) {
            this.msg = msg;
        }

        ;
        private String msg;

        public String getMsg() {
            return msg;
        }
    }

    /**
     * 订单商品评价
     */
    public enum orderEvaluation {

        ORDER_EVALUATION_SUCCESS("评价成功")
        ;

        orderEvaluation(String msg) {
            this.msg = msg;
        }

        ;
        private String msg;

        public String getMsg() {
            return msg;
        }
    }
}
