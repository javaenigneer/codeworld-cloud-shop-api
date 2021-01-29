package com.codeworld.fc.system.area.controller;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.system.area.service.AreaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName AreaController
 * Description 区域管理接口
 * Author Lenovo
 * Date 2021/1/29
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-system/area")
public class AreaController {

    @Autowired(required = false)
    private AreaService areaService;

    @GetMapping("tree-area")
    @ApiOperation("获取区域树")
    @PassToken
    public FCResponse<Object> treeArea(){
        return this.areaService.treeArea();
    }
}
