package com.codeworld.fc.marketing.carouse.service;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.marketing.carouse.entity.Carouse;
import com.codeworld.fc.marketing.carouse.request.CarouseAddRequest;
import com.codeworld.fc.marketing.carouse.request.CarouseSearchRequest;

import java.util.List;

public interface CarouseService {

    /**
     * 分页获取轮播图
     * @param carouseSearchRequest
     * @return
     */
    FCResponse<DataResponse<List<Carouse>>> getPageCarouse(CarouseSearchRequest carouseSearchRequest);

    /**
     * 添加轮播图
     * @param carouseAddRequest
     * @return
     */
    FCResponse<Void> addCarouse(CarouseAddRequest carouseAddRequest);

    /**
     * 改变轮播图状态
     * @param carouse
     */
    void updateCarouseStatus(Carouse carouse);

    /**
     * 获取已上线的轮播图
     * @return
     */
    FCResponse<List<Carouse>> getCarouseEnable();

    /**
     * 定时删除结束时间大于于当前时间1天的数据
     * @param carouseIds
     */
    void deleteCarouseTime(List<Long> carouseIds);

    /**
     * 查询结束时间大于当前日期一天的轮播图
     * @return
     */
    List<Long> getCarouseEndTimeGtNow();

    /**
     * 分页获取营销管理员轮播图
     * @param carouseSearchRequest
     * @return
     */
    FCResponse<DataResponse<List<Carouse>>> getPageCarouseMarketingSystem(CarouseSearchRequest carouseSearchRequest);
}
