package com.codeworld.fc.goods.attribute.service;

import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.goods.attribute.request.CategoryAttributeAddRequest;
import com.codeworld.fc.goods.attribute.request.CategoryAttributeSearchRequest;
import com.codeworld.fc.goods.attribute.response.CategoryAttributeResponse;

import java.util.List;

public interface CategoryAttributeService {
    /**
     * 分页获取分类属性
     * @param categoryAttributeSearchRequest
     * @return
     */
    FCResponse<DataResponse<List<CategoryAttributeResponse>>> getPageCategoryAttribute(CategoryAttributeSearchRequest categoryAttributeSearchRequest);

    /**
     * 添加分类属性
     * @param categoryAttributeAddRequest
     * @return
     */
    FCResponse<Void> addCategoryAttribute(CategoryAttributeAddRequest categoryAttributeAddRequest);

    /**
     * 查询该分类的状态
     * @param categoryId
     * @return
     */
    FCResponse<Void> getCategoryStatus(Long categoryId);

    /**
     * 查询已设置的分类属性
     * @return
     */
    FCResponse<List<CategoryAttributeResponse>> getCategoryAttribute();
}
