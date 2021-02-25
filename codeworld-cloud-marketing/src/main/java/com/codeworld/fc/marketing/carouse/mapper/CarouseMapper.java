package com.codeworld.fc.marketing.carouse.mapper;

import com.codeworld.fc.marketing.carouse.entity.Carouse;
import com.codeworld.fc.marketing.carouse.request.CarouseSearchRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CarouseMapper {

    /**
     * 分页查询轮播图
     * @param carouseSearchRequest
     * @return
     */
    List<Carouse> getPageCarouse(CarouseSearchRequest carouseSearchRequest);

    /**
     * 添加轮播图
     * @param carouse
     */
    void addCarouse(Carouse carouse);

    /**
     * 改变轮播图状态
     * @param carouse
     */
    void updateCarouseStatus(Carouse carouse);

    /**
     * 获取已上线的轮播图
     * @return
     */
    List<Carouse> getCarouseEnable();

    /**
     * 定时删除结束时间大于于当前时间1天的数据
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
    List<Carouse> getPageCarouseMarketingSystem(CarouseSearchRequest carouseSearchRequest);

    /**
     * 根据id查询轮播图信息
     * @param id
     * @return
     */
    Carouse getCarouseById(Long id);
}
