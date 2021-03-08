package com.codeworld.fc.logistics.controller;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.logistics.request.LogisticsRequest;
import com.codeworld.fc.logistics.request.LogisticsSelectRequest;
import com.codeworld.fc.logistics.response.LogisticsInformationCollection;
import com.codeworld.fc.logistics.service.LogisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * ClassName LogisticsController
 * Description 物流接口管理
 * Author Lenovo
 * Date 2021/3/3
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-logistics")
@Api(tags = "物流接口管理")
public class LogisticsController {

    @Autowired(required = false)
    private LogisticsService logisticsService;

    @PostMapping("update-logistics")
    @ApiOperation("物流更新")
    public FCResponse<Void> updateLogistics(@RequestBody @Valid LogisticsRequest logisticsRequest){
        return this.logisticsService.updateLogistics(logisticsRequest);
    }

    @PostMapping("get-logistics-information")
    @ApiOperation("获取物流信息")
    public FCResponse<LogisticsInformationCollection> getLogisticsInformation(@RequestBody @Valid LogisticsSelectRequest logisticsSelectRequest){
        return this.logisticsService.getLogisticsInformation(logisticsSelectRequest);
    }
}
