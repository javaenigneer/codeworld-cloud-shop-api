### Codeworld-Cloud-Shop
### Welcome Lady And 乡亲们
扫码加入我们吧
![QQ群](https://fcblog-1300450814.cos.ap-chengdu.myqcloud.com/2020/hexoblog/temp_qrcode_share_964285437.png)
![公众号](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/qrcode_for_gh_e90987068371_258.jpg)
#### 介绍

Codeworld-Cloud-shop是一套比较完整的商城系统，采用的是目前流行的框架技术完成

本套codeworld-cloud-shop是一个电商项目，后端采用微服务的形式实现，主要采用SpringBoot+MyBatis实现，融合了多种技术，Nacos(服务注册中心)、Gateway(网关)、OpenFeign（远程调用）Redis(缓存)、RabbitMQ（消息队列）、ElasticSearch（搜索引擎）、XXL-JOB（任务调度）等技术。前台商城采用uniapp模板，有商城首页、广告轮播图、分类展示、商品搜索、商品展示、商品规格选择、购物车、订单查询、订单流程等模块。后台系统采用vue，使用多商户登录平台、有系统管理、商品管理、商户管理、订单管理、营销管理等模块

#### 个人博客
[CodeWorld博客](http://123.56.81.75)
#### 文档地址
[CodeWorld-Cloud-Shop文档地址](http://123.56.81.75/document/#/)

#### 项目技术选型
##### 后端技术

|         技术         |        说明         |                         官网                         |
| :------------------: | :-----------------: | :--------------------------------------------------: |
|      SpringBoot      |       MVC框架       |        https://spring.io/projects/spring-boot        |
|       MyBatis        |       ORM框架       |          http://www.mybatis.org/mybatis-3/           |
|  SpringBoot-Gateway  |        网关         |   https://spring.io/projects/spring-cloud-gateway    |
|        Redis         |      缓存服务       |     https://spring.io/projects/spring-data-redis     |
|       RabbitMQ       |      消息队列       |              https://www.rabbitmq.com/               |
|      OpenFeign       |      远程调用       |  https://spring.io/projects/spring-cloud-openfeign   |
|    ElasticSearch     |      搜索引擎       | https://spring.io/projects/spring-data-elasticsearch |
|       XXL-JOB        |      任务调度       |           https://www.xuxueli.com/xxl-job/           |
|         JWT          |     JWT登录支持     |             https://github.com/jwtk/jjwt             |
|        Lombok        |    简化对象封装     |        https://github.com/rzwitserloot/lombok        |
|        Hutool        |     Java工具类      |           https://github.com/looly/hutool            |
|      PageHelper      | MyBatis物理分页插件 |    http://git.oschina.net/free/Mybatis_PageHelper    |
|      Swagger-UI      |    文档生成工具     |      https://github.com/swagger-api/swagger-ui       |
| Hibernator-Validator |      验证框架       |            http://hibernate.org/validator            |

##### 前端系统技术选型

|    技术    |       说明       |                         官网                          |
| :--------: | :--------------: | :---------------------------------------------------: |
|    Vue     |     前端框架     |                  https://vuejs.org/                   |
| Vue-router |     路由框架     |               https://router.vuejs.org/               |
|    Vuex    | 全局状态管理框架 |                https://vuex.vuejs.org/                |
|  Element   |    前端UI框架    | [https://element.eleme.io](https://element.eleme.io/) |
|   Axios    |   前端HTTP框架   |            https://github.com/axios/axios             |

##### 前端系统app技术选型

**Uniapp**    官网：https://dcloud.io/

#### 系统模块（Codeworld-Cloud-Shop）后面会继续追加，敬请期待

```text
|---系统管理
  --- 用户管理
  --- 角色管理
  --- 菜单管理
  --- 部门管理
```
#### 商户系统模块（Codeworld-Cloud-Shop）后面会继续追加，敬请期待
```text
|--- 商品管理
  --- 商品信息
  --- 分类管理
  --- 分类属性
|--- 商户管理
  --- 商户信息
|--- 订单管理
  --- 订单列表
  --- 订单退款退货列表
|--- 营销管理
  --- 首页轮播图
|--- 店铺管理
  --- 店铺列表
  --- 店铺分类
```
#### 组织结构

```java
codeworld-cloud-shop
    --- codeworld-cloud-auth 用户认证授权同意中心
    --- codeworld-cloud-cart 购物车模块
    --- codeworld-cloud-common 公共模块
    --- codeworld-cloud-gateway 网关模块
    --- codeworld-cloud-goods 商品模块
    --- codeworld-cloud-marketing 营销模块
    --- codeworld-cloud-member 会员模块
    --- codeworld-cloud-merchant 商户模块
    --- codeworld-cloud-order 订单模块
    --- codeworld-cloud-search 搜索模块
    --- codeworld-cloud-sms 短信发送模块
    --- codeworld-cloud-system 系统模块
    --- codeworld-cloud-upload 上传模块
    --- codeworld-cloud-logistics 物流模块
    --- codeworld-cloud-admin admin监控模块
```

#### 端口信息

```java
codeworld-cloud-shop
   --- codeworld-cloud-auth -----> 8004 认证中心
   --- codeworld-cloud-cart -----> 3001 购物车
   --- codeworld-cloud-gateway -----> 8888 网关中心
   --- codeworld-cloud-goods -----> 9001 商品
   --- codeworld-cloud-marketing -----> 9003 营销
   --- codeworld-cloud-member -----> 5001 会员
   --- codeworld-cloud-merchant -----> 5002 商户
   --- codeworld-cloud-order -----> 2001 订单
   --- codeworld-cloud-search -----> 7001 搜索
   --- codeworld-cloud-sms -----> 4001 短信发送
   --- codeworld-cloud-system -----> 8001 系统
   --- codeworld-cloud-upload -----> 6001 上传
   --- codeworld-cloud-logistics -----> 2002 物流
   --- codeworld-cloud-admin -----> 10000 监控
定时任务端口    
xxl-job-admin ----> 9999
xxl-job-merchant ----> 5003
xxl-job-product ----> 9002
xxl-job-marketing ----> 9004
```

#### 项目链接

前端Web项目(系统后台)：[系统后台](https://github.com/javaenigneer/code-shop-system)
前端Web项目(商户后台)：[商户后台](https://github.com/javaenigneer/code-merchant-system)
前端app：[前端App](https://github.com/javaenigneer/code-shop-app)

#### 系统截图

##### 系统管理

###### 登录界面

![系统登录](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/login-system.png)

###### 系统主界面

![系统主界面](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/system-index.png)

###### 用户管理

![用户管理](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/system-user.png)

###### 角色管理

![角色管理](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/system-role.png)

###### 菜单管理

![菜单管理](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/system-menu.png)

###### 部门管理

![部门管理](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/system-dept.png)

##### 商品管理

###### 商品信息

![商品信息](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/goods-index.png)

###### 添加商品

![添加商品](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/goods-add.png)

###### 分类管理

![分类管理](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/category-index.png)

###### 添加分类

![添加分类](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/category-add.png)

###### 分类属性

![分类属性](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/category-attribute.png)

##### 订单管理

###### 订单列表

![订单列表](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/order-index.png)

###### 订单详情

![订单详情](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/order-detail.png)

##### 营销管理

###### 轮播图列表

![轮播图列表](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/marketing-carouse.png)

###### 添加轮播图

![添加轮播图](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/system-shop/carouse-add.png)

#### App端截图

##### 登录页面

![登录页面](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/app/app-login.png)	

##### 注册页面

![注册页面](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/app/app-register.png)

##### App首页

![App首页](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/app/app-index.png)

##### 分类页面

![分类页面](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/app/app-category.png)

##### 商品详情

![商品详情](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/app/app-goods-detail.png)

##### 购物车

![购物车](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/app/app-cart.png)

##### 结算页面

![结算页面](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/app/app-cart-settlement.png)

##### 支付页面

![支付页面](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/app/app-pay.png)

##### 订单列表

![订单列表](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/app/app-order.png)

##### 个人界面

![个人界面](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/app/app-user.png)

##### 收货地址

![收货地址](https://codeworld-cloud-shop-1300450814.cos.ap-chengdu.myqcloud.com/app/app-address.png)
