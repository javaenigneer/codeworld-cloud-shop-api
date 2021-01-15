package com.codeworld.fc.goods.attribute.controller;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.attribute.request.AttributeAddRequest;
import com.codeworld.fc.goods.attribute.request.AttributeSearchRequest;
import com.codeworld.fc.goods.attribute.response.AttributeResponse;
import com.codeworld.fc.goods.attribute.service.AttributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ClassName AttributeController
 * Description 属性接口管理
 * Author Lenovo
 * Date 2020/12/4
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-goods/attribute")
@Api(tags = "属性接口管理")
public class AttributeController {

    @Autowired(required = false)
    private AttributeService attributeService;

    @PostMapping("get-page-attribute")
    @ApiOperation("分页查询属性")
    public FCResponse<DataResponse<List<AttributeResponse>>> getPageAttribute(@RequestBody AttributeSearchRequest attributeSearchRequest){
        return this.attributeService.getPageAttribute(attributeSearchRequest);
    }

    @PostMapping("add-attribute")
    @ApiOperation("添加属性")
    public FCResponse<Void> addAttribute(@RequestBody @Valid AttributeAddRequest attributeAddRequest){
        return this.attributeService.addAttribute(attributeAddRequest);
    }

}
