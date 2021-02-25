package com.codeworld.fc.marketing.carouse.controller;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.marketing.carouse.entity.Carouse;
import com.codeworld.fc.marketing.carouse.request.CarouseAddRequest;
import com.codeworld.fc.marketing.carouse.request.CarouseSearchRequest;
import com.codeworld.fc.marketing.carouse.request.ReviewCarouseRequest;
import com.codeworld.fc.marketing.carouse.service.CarouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ClassName CarouseController
 * Description 轮播图接口管理
 * Author Lenovo
 * Date 2021/1/13
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-marketing/carouse")
@Api(tags = "轮播图接口管理")
public class CarouseController {

    @Autowired(required = false)
    private CarouseService carouseService;

    @PostMapping("get-page-carouse")
    @ApiOperation("商户分页获取首页轮播图")
    public FCResponse<DataResponse<List<Carouse>>> getPageCarouse(@RequestBody CarouseSearchRequest carouseSearchRequest){
        return this.carouseService.getPageCarouse(carouseSearchRequest);
    }

    @PostMapping("add-carouse")
    @ApiOperation("添加轮播图")
    public FCResponse<Void> addCarouse(@RequestBody @Valid CarouseAddRequest carouseAddRequest){
        return this.carouseService.addCarouse(carouseAddRequest);
    }

    @GetMapping("get-carouse-enable")
    @ApiOperation("获取已上线的轮播图")
    @PassToken
    public FCResponse<List<Carouse>> getCarouseEnable(){
        return this.carouseService.getCarouseEnable();
    }

    @PostMapping("get-page-carouse-marketing-system")
    @ApiOperation("营销管理员分页获取首页轮播图")
    public FCResponse<DataResponse<List<Carouse>>> getPageCarouseMarketingSystem(@RequestBody CarouseSearchRequest carouseSearchRequest){
        return this.carouseService.getPageCarouseMarketingSystem(carouseSearchRequest);
    }

    @PostMapping("review-carouse")
    @ApiOperation("审核轮播图")
    public FCResponse<Void> reviewCarouse(@RequestBody @Valid ReviewCarouseRequest reviewCarouseRequest){
        return this.carouseService.reviewCarouse(reviewCarouseRequest);
    }

    @PostMapping("delete-carouse")
    @ApiOperation("删除轮播图")
    public FCResponse<Void> deleteCarouse(@RequestParam("id") Long id){
        return this.carouseService.deleteCarouse(id);
    }
}
