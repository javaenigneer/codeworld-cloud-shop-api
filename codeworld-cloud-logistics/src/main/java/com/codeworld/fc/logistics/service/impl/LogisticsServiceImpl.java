package com.codeworld.fc.logistics.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codeworld.fc.client.OrderClient;
import com.codeworld.fc.client.UserClient;
import com.codeworld.fc.common.domain.LoginInfoData;
import com.codeworld.fc.common.enums.DeliveryEnum;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.domain.User;
import com.codeworld.fc.interceptor.AuthInterceptor;
import com.codeworld.fc.logistics.domain.LogisticsInformation;
import com.codeworld.fc.logistics.entity.Logistics;
import com.codeworld.fc.logistics.mapper.LogisticsMapper;
import com.codeworld.fc.logistics.request.LogisticsRequest;
import com.codeworld.fc.logistics.request.LogisticsSelectRequest;
import com.codeworld.fc.logistics.response.LogisticsInformationCollection;
import com.codeworld.fc.logistics.service.LogisticsService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ClassName LogisticsServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2021/3/3
 * Version 1.0
 **/
@Service
public class LogisticsServiceImpl implements LogisticsService {

    @Autowired(required = false)
    private LogisticsMapper logisticsMapper;

    @Autowired(required = false)
    private UserClient userClient;
    @Autowired(required = false)
    private OrderClient orderClient;

    /**
     * 物流MQ监听发货（自动更新）
     *
     * @param logistics
     * @return
     */
    public Integer logisticsDelivery(Logistics logistics) {
        // 设置基本信息
        logistics.setId(IDGeneratorUtil.getNextId());
        logistics.setArriveTime(new Date());
        logistics.setContent("订单开始处理");
        try {
            this.logisticsMapper.logisticsDelivery(logistics);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 物流更新
     *
     * @param logisticsRequest
     * @return
     */
    public FCResponse<Void> updateLogistics(LogisticsRequest logisticsRequest) {
        LoginInfoData loginInfoData = AuthInterceptor.getLoginInfo();
        if (ObjectUtils.isEmpty(loginInfoData)){
            throw new FCException("登录失效");
        }
        FCResponse<User> fcResponse = this.userClient.getUserById(loginInfoData.getId());
        if (!fcResponse.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode())){
            return FCResponse.dataResponse(fcResponse.getCode(),fcResponse.getMsg());
        }
        // 查询是否有该订单号和物流号一致
        FCResponse<Boolean> response = this.orderClient.checkOrderIdAndDeliveryNumberExist(logisticsRequest.getOrderId(), logisticsRequest.getDeliveryNumber());
        if (!response.getCode().equals(HttpFcStatus.DATASUCCESSGET.getCode()) | !response.getData()){
            return FCResponse.dataResponse(response.getCode(),response.getMsg());
        }
        User user = fcResponse.getData();
        Logistics logistics = new Logistics();
        BeanUtil.copyProperties(logisticsRequest,logistics);
        logistics.setId(IDGeneratorUtil.getNextId());
        logistics.setArriveTime(new Date());
        logistics.setOperationId(user.getUserId());
        logistics.setOperationName(user.getUserName());
        try {
            this.logisticsMapper.logisticsDelivery(logistics);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.logistics.LOGISTICS_UPDATE_SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }

    /**
     * 获取物流信息
     *
     * @param logisticsSelectRequest
     * @return
     */
    @Override
    public FCResponse<LogisticsInformationCollection> getLogisticsInformation(LogisticsSelectRequest logisticsSelectRequest) {
        List<Logistics> logisticsEs = this.logisticsMapper.getLogisticsByDeliveruNumberAndOrderId(logisticsSelectRequest);
        if (CollectionUtils.isEmpty(logisticsEs)){
            return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(),HttpMsg.logistics.LOGISTICS_DATA_EMPTY.getMsg());
        }
        // 创建数据返回对象
        LogisticsInformationCollection logisticsInformationCollection = new LogisticsInformationCollection();
        // 创建物流基本信息
        LogisticsInformation logisticsInformation = new LogisticsInformation();
        Logistics logistics = logisticsEs.get(0);
        logisticsInformation.setDeliveryCompany(DeliveryEnum.getDeliveryNameByKey(logistics.getDeliverySn()));
        logisticsInformation.setDeliveryNumber(logistics.getDeliveryNumber());
        // 设置物流基本信息
        logisticsInformationCollection.setInformation(logisticsInformation);
        // 设置物流动态信息
        logisticsInformationCollection.setLogistics(logisticsEs);
        // 默认设置信息
        logisticsInformationCollection.setUpdateTime(new Date());
        logisticsInformationCollection.setState(3);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.logistics.LOGISTICS_DATA_SUCCESS.getMsg(),logisticsInformationCollection);
    }
}
