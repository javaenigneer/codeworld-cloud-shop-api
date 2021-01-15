package com.codeworld.fc.goods.attribute.mapper;

import com.codeworld.fc.goods.attribute.entity.CategoryAttribute;
import com.codeworld.fc.goods.attribute.request.CategoryAttributeSearchRequest;
import com.codeworld.fc.goods.attribute.response.CategoryAttributeResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryAttributeMapper {

    /**
     * 分页获取分类属性
     * @param categoryAttributeSearchRequest
     * @return
     */
    List<CategoryAttributeResponse> getPageCategoryAttribute(CategoryAttributeSearchRequest categoryAttributeSearchRequest);

    /**
     * 添加分类属性
     * @param categoryAttribute
     */
    void addCategoryAttribute(CategoryAttribute categoryAttribute);

    /**
     * 查询分类状态，是否已设置属性
     * @param categoryId
     * @return
     */
    Integer getCategoryStatus(Long categoryId);

    /**
     * 查询已设置的分类属性
     * @return
     */
    List<CategoryAttributeResponse> getCategoryAttribute();
}
