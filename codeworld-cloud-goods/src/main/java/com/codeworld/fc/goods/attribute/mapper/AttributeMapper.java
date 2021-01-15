package com.codeworld.fc.goods.attribute.mapper;

import com.codeworld.fc.goods.attribute.entity.Attribute;
import com.codeworld.fc.goods.attribute.request.AttributeSearchRequest;
import com.codeworld.fc.goods.attribute.response.AttributeResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AttributeMapper {
    /**
     * 添加属性
     * @param attribute
     */
    void addAttribute(Attribute attribute);

    /**
     * 分页查询属性
     * @param attributeSearchRequest
     * @return
     */
    List<AttributeResponse> getPageAttribute(AttributeSearchRequest attributeSearchRequest);

    /**
     * 根据分类Id查询该分类下的属性Id
     * @param categoryId
     * @return
     */
    List<Long> getAttributeIdsByCategoryId(Long categoryId);
}
