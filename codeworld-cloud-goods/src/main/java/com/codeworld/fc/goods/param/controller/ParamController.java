package com.codeworld.fc.goods.param.controller;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.attribute.response.AttributeResponse;
import com.codeworld.fc.goods.param.request.ParamAddRequest;
import com.codeworld.fc.goods.param.request.ParamSearchRequest;
import com.codeworld.fc.goods.param.response.ParamResponse;
import com.codeworld.fc.goods.param.service.ParamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ClassName ParamController
 * Description 参数接口管理
 * Author Lenovo
 * Date 2020/12/7
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-goods/param")
@Api(tags = "参数接口管理")
public class ParamController {

    @Autowired(required = false)
    private ParamService paramService;

    @PostMapping("get-page-param")
    @ApiOperation("分页获取参数")
    public FCResponse<DataResponse<List<ParamResponse>>> getPageParam(@RequestBody @Valid ParamSearchRequest paramSearchRequest){
        return this.paramService.getPageParam(paramSearchRequest);
    }

    @PostMapping("add-param")
    @ApiOperation("添加参数")
    public FCResponse<Void> addParam(@RequestBody @Valid ParamAddRequest paramAddRequest){
        return this.paramService.addParam(paramAddRequest);
    }

    @PostMapping("get-param-category-id")
    @ApiOperation("查询分类下的属性的参数")
    @PassToken
    public FCResponse<List<ParamResponse>> getParamByCategoryId(@RequestParam("categoryId") Long categoryId){
        return this.paramService.getParamByCategoryId(categoryId);
    }

    @PostMapping("get-special-param-category-id")
    @ApiOperation("查询分类下的属性的特有参数")
    public FCResponse<List<ParamResponse>> getSpecialParamByCategoryId(@RequestParam("categoryId") Long categoryId){
        return this.paramService.getSpecialParamByCategoryId(categoryId);
    }
}
