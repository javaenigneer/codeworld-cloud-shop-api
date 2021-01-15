package com.codeworld.fc.goods.category.controller;

import com.codeworld.fc.common.auth.PassToken;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.category.entity.Category;
import com.codeworld.fc.goods.category.request.CategoryRequest;
import com.codeworld.fc.goods.category.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ClassName CategoryController
 * Description 商品分类接口管理
 * Author Lenovo
 * Date 2020/11/27
 * Version 1.0
**/
@RestController
@RequestMapping("codeworld-goods")
@Api(tags = "商品分类接口管理")
public class CategoryController {

    @Autowired(required = false)
    private CategoryService categoryService;

    // 获取全部商品分类
    @PostMapping("/category/tree-category")
    @ApiOperation("获取分类树")
    @PassToken
    public FCResponse<Object> treeCategory(){
        return this.categoryService.treeCategory();
    }

    // 添加分类
    @PostMapping("/category/add-category")
    @ApiOperation("添加分类")
    public FCResponse<Void> addCategory(@RequestBody @Valid CategoryRequest categoryRequest){
        return this.categoryService.addCategory(categoryRequest);
    }

    @PostMapping("/category/update-category")
    @ApiOperation("编辑分类")
    public FCResponse<Void> updateCategory(@RequestBody @Valid CategoryRequest categoryRequest){
        return this.categoryService.updateCategory(categoryRequest);
    }

    @PostMapping("/category/get-all-category")
    @ApiOperation("获取全部分类")
    @PassToken
    public FCResponse<List<Category>> getAllCategory(){
        return this.categoryService.getAllCategory();
    }

    @PostMapping("/category/delete-category")
    @ApiOperation("删除分类")
    public FCResponse<Void> deleteCategory(@RequestParam("categoryId") Long categoryId){
        return this.categoryService.deleteCategory(categoryId);
    }

    @PostMapping("/category/get-category-id")
    @ApiOperation("根据分类id获取分类信息")
    @PassToken
    public FCResponse<Category> getCategoryById(@RequestParam("categoryId") Long categoryId){
        return this.categoryService.getCategoryById(categoryId);
    }

    @GetMapping("/category/get-parent-category-app")
    @ApiOperation("获取父级分类-app")
    @PassToken
    public FCResponse<List<Category>> getParentCategory(){
        return this.categoryService.getParentCategory();
    }
}
