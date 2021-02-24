package com.codeworld.fc.marketing.carouse.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.codeworld.fc.common.domain.LoginInfoData;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.common.utils.JsonUtils;
import com.codeworld.fc.marketing.carouse.entity.Carouse;
import com.codeworld.fc.marketing.carouse.mapper.CarouseMapper;
import com.codeworld.fc.marketing.carouse.request.CarouseAddRequest;
import com.codeworld.fc.marketing.carouse.request.CarouseSearchRequest;
import com.codeworld.fc.marketing.carouse.service.CarouseService;
import com.codeworld.fc.marketing.client.MerchantClient;
import com.codeworld.fc.marketing.domain.MerchantResponse;
import com.codeworld.fc.marketing.interceptor.AuthInterceptor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * ClassName CarouseServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2021/1/13
 * Version 1.0
 **/
@Service
public class CarouseServiceImpl implements CarouseService {

    @Autowired(required = false)
    private CarouseMapper carouseMapper;
    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;
    @Autowired(required = false)
    private AmqpTemplate amqpTemplate;

    private static final String CAROUSE_ENABLE = "carouse_enable";

    @Autowired(required = false)
    private MerchantClient merchantClient;

    /**
     * 分页获取轮播图
     *
     * @param carouseSearchRequest
     * @return
     */
    public FCResponse<DataResponse<List<Carouse>>> getPageCarouse(CarouseSearchRequest carouseSearchRequest) {
        // 判断是否登录
        LoginInfoData loginInfoData = AuthInterceptor.getLoginInfo();
        if (ObjectUtils.isEmpty(loginInfoData)){
            throw new FCException("登录失效，请重新登录");
        }
        // 根据id获取商户号
        FCResponse<MerchantResponse> merchantFcResponse = this.merchantClient.getMerchantNumberAndNameById(loginInfoData.getId());
        if (!merchantFcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            throw new FCException(merchantFcResponse.getMsg());
        }
        MerchantResponse merchantResponse = merchantFcResponse.getData();
        carouseSearchRequest.setMerchantNumber(merchantResponse.getNumber());
        PageHelper.startPage(carouseSearchRequest.getPage(), carouseSearchRequest.getLimit());
        List<Carouse> carouses = this.carouseMapper.getPageCarouse(carouseSearchRequest);
        if (CollectionUtils.isEmpty(carouses)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.carouse.CAROUSE_DATA_EMPTY.getMsg(), DataResponse.dataResponse(carouses, 0L));
        }
        PageInfo<Carouse> pageInfo = new PageInfo<>(carouses);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.carouse.CAROUSE_DATA_SUCCESS.getMsg(), DataResponse.dataResponse(pageInfo.getList(), pageInfo.getTotal()));
    }

    /**
     * 添加轮播图
     *
     * @param carouseAddRequest
     * @return
     */
    @Override
    public FCResponse<Void> addCarouse(CarouseAddRequest carouseAddRequest) {
        // 判断是否登录
        LoginInfoData loginInfoData = AuthInterceptor.getLoginInfo();
        if (ObjectUtils.isEmpty(loginInfoData)){
            throw new FCException("登录失效，请重新登录");
        }
        // 根据id获取商户号
        FCResponse<MerchantResponse> merchantFcResponse = this.merchantClient.getMerchantNumberAndNameById(loginInfoData.getId());
        if (!merchantFcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())) {
            throw new FCException(merchantFcResponse.getMsg());
        }
        MerchantResponse merchantResponse = merchantFcResponse.getData();
        // 判断开始时间和结束时间的比较
        if (DateUtil.compare(carouseAddRequest.getStartTime(), new Date()) < 0
                || DateUtil.compare(carouseAddRequest.getEndTime(), new Date()) < 0) {
            // 开始时间和结束时间要大于当前时间
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.carouse.CAROUSE_DATE_ERROR.getMsg());
        }
        // 判断开始时间和结束时间
        if (DateUtil.compare(carouseAddRequest.getStartTime(), carouseAddRequest.getEndTime()) > 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.carouse.CAROUSE_END_DATE_ERROR.getMsg());
        }
        Carouse carouse = new Carouse();
        BeanUtil.copyProperties(carouseAddRequest, carouse);
        carouse.setId(IDGeneratorUtil.getNextId());
        carouse.setCreateTime(new Date());
        carouse.setMerchantNumber(merchantResponse.getNumber());
        // 设置为未审核状态
        carouse.setReviewStatus(0);
        // 默认这是为app首页
        carouse.setPosition(carouseAddRequest.getPosition());
        this.carouseMapper.addCarouse(carouse);
        // 实现异步操作
        //现将carouse序列化
        String json = JsonUtils.serialize(carouse);
        this.amqpTemplate.convertAndSend("carouse.update.status.enable", json);
        this.amqpTemplate.convertAndSend("carouse.update.status.disable",json);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.carouse.CAROUSE_ADD_SUCCESS.getMsg());
    }

    /**
     * 改变轮播图状态
     *
     * @param carouse
     */
    @Override
    public void updateCarouseStatus(Carouse carouse) {
        this.carouseMapper.updateCarouseStatus(carouse);
        // 删除redis中的轮播图缓存
        this.stringRedisTemplate.delete(CAROUSE_ENABLE);
    }

    /**
     * 获取已上线的轮播图
     *
     * @return
     */
    @Override
    public FCResponse<List<Carouse>> getCarouseEnable() {
        // 先从redis中获取已上线的轮播图
        if (this.stringRedisTemplate.hasKey(CAROUSE_ENABLE)){
            String json = this.stringRedisTemplate.opsForValue().get(CAROUSE_ENABLE);
            if (ObjectUtils.isNotEmpty(json)){
                List<Carouse> carouses = JsonUtils.parseList(json, Carouse.class);
                return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.carouse.CAROUSE_DATA_SUCCESS.getMsg(),carouses);
            }
        }
        // 从数据库中查询数据
        List<Carouse> carouses = this.carouseMapper.getCarouseEnable();
        if (CollectionUtils.isEmpty(carouses)){
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(),HttpMsg.carouse.CAROUSE_DATA_EMPTY.getMsg());
        }
        // 添加到redis中
        String json = JsonUtils.serialize(carouses);
        this.stringRedisTemplate.opsForValue().set(CAROUSE_ENABLE,json);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.carouse.CAROUSE_DATA_SUCCESS.getMsg(),carouses);
    }

    /**
     * 定时删除结束时间大于于当前时间1天的数据
     * @param carouseIds
     */
    @Override
    public void deleteCarouseTime(List<Long> carouseIds) {
        this.carouseMapper.deleteCarouseTime(carouseIds);
    }

    /**
     * 查询结束时间大于当前日期一天的轮播图
     *
     * @return
     */
    @Override
    public List<Long> getCarouseEndTimeGtNow() {
        return this.carouseMapper.getCarouseEndTimeGtNow();
    }

    /**
     * 分页获取营销管理员轮播图
     *
     * @param carouseSearchRequest
     * @return
     */
    @Override
    public FCResponse<DataResponse<List<Carouse>>> getPageCarouseMarketingSystem(CarouseSearchRequest carouseSearchRequest) {
        PageHelper.startPage(carouseSearchRequest.getPage(), carouseSearchRequest.getLimit());
        List<Carouse> carouses = this.carouseMapper.getPageCarouseMarketingSystem(carouseSearchRequest);
        if (CollectionUtils.isEmpty(carouses)) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(), HttpMsg.carouse.CAROUSE_DATA_EMPTY.getMsg(), DataResponse.dataResponse(carouses, 0L));
        }
        PageInfo<Carouse> pageInfo = new PageInfo<>(carouses);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.carouse.CAROUSE_DATA_SUCCESS.getMsg(), DataResponse.dataResponse(pageInfo.getList(), pageInfo.getTotal()));
    }
}
