package com.codeworld.fc.goods.attribute.controller;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.attribute.request.CategoryAttributeAddRequest;
import com.codeworld.fc.goods.attribute.request.CategoryAttributeSearchRequest;
import com.codeworld.fc.goods.attribute.response.CategoryAttributeResponse;
import com.codeworld.fc.goods.attribute.service.CategoryAttributeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ClassName CategoryAttributeController
 * Description 分类属性接口管理
 * Author Lenovo
 * Date 2020/12/3
 * Version 1.0
 **/
@RestController
@RequestMapping("codeworld-goods/category-attribute")
public class CategoryAttributeController {


    @Autowired(required = false)
    private CategoryAttributeService categoryAttributeService;

    @PostMapping("get-page-category-attribute")
    @ApiOperation("分页获取分类属性")
    public FCResponse<DataResponse<List<CategoryAttributeResponse>>> getPageCategoryAttribute(@RequestBody CategoryAttributeSearchRequest categoryAttributeSearchRequest) {
        return this.categoryAttributeService.getPageCategoryAttribute(categoryAttributeSearchRequest);
    }

    @PostMapping("add-category-attribute")
    @ApiOperation("添加分类属性")
    public FCResponse<Void> addCategoryAttribute(@RequestBody @Valid CategoryAttributeAddRequest categoryAttributeAddRequest) {
        return this.categoryAttributeService.addCategoryAttribute(categoryAttributeAddRequest);
    }

    @PostMapping("get-category-status")
    @ApiOperation("查询该分类状态")
    public FCResponse<Void> getCategoryStatus(@RequestParam("categoryId") Long categoryId) {
        return this.categoryAttributeService.getCategoryStatus(categoryId);
    }

    @PostMapping("get-category-attribute")
    @ApiOperation("查询已设置的分类属性")
    public FCResponse<List<CategoryAttributeResponse>> getCategoryAttribute() {
        return this.categoryAttributeService.getCategoryAttribute();
    }
}
