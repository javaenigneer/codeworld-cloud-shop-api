package com.codeworld.fc.goods.category.service;

import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.category.entity.Category;
import com.codeworld.fc.goods.category.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    /**
     * 获取全部分类
     * @return
     */
    FCResponse<Object> treeCategory();

    /**
     * 添加分类
     * @param categoryRequest
     * @return
     */
    FCResponse<Void> addCategory(CategoryRequest categoryRequest);

    /**
     * 编辑分类
     * @param categoryRequest
     * @return
     */
    FCResponse<Void> updateCategory(CategoryRequest categoryRequest);

    /**
     * 获取全部分类
     * @return
     */
    FCResponse<List<Category>> getAllCategory();

    /**
     * 删除分类
     * @param categoryId
     * @return
     */
    FCResponse<Void> deleteCategory(Long categoryId);

    /**
     * 根据分类id获取分类信息
     * @param categoryId
     * @return
     */
    FCResponse<Category> getCategoryById(Long categoryId);

    /**
     * 获取父级分类-app
     * @return
     */
    FCResponse<List<Category>> getParentCategory();
}
