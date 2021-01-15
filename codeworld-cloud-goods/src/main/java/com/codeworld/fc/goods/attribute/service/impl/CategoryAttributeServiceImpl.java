package com.codeworld.fc.goods.attribute.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.response.DataResponse;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.goods.attribute.entity.Attribute;
import com.codeworld.fc.goods.attribute.entity.CategoryAttribute;
import com.codeworld.fc.goods.attribute.mapper.AttributeMapper;
import com.codeworld.fc.goods.attribute.mapper.CategoryAttributeMapper;
import com.codeworld.fc.goods.attribute.request.CategoryAttributeAddRequest;
import com.codeworld.fc.goods.attribute.request.CategoryAttributeSearchRequest;
import com.codeworld.fc.goods.attribute.response.CategoryAttributeResponse;
import com.codeworld.fc.goods.attribute.service.CategoryAttributeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

/**
 * ClassName CategoryAttributeServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/12/3
 * Version 1.0
 **/
@Service
public class CategoryAttributeServiceImpl implements CategoryAttributeService {

    @Autowired(required = false)
    private CategoryAttributeMapper categoryAttributeMapper;
    @Autowired(required = false)
    private AttributeMapper attributeMapper;

    /**
     * 分页获取分类属性
     *
     * @param categoryAttributeSearchRequest
     * @return
     */
    @Override
    public FCResponse<DataResponse<List<CategoryAttributeResponse>>> getPageCategoryAttribute(CategoryAttributeSearchRequest categoryAttributeSearchRequest) {
        PageHelper.startPage(categoryAttributeSearchRequest.getPage(), categoryAttributeSearchRequest.getLimit());
        List<CategoryAttributeResponse> categoryAttributeResponses = this.categoryAttributeMapper.getPageCategoryAttribute(categoryAttributeSearchRequest);
        if (CollectionUtils.isEmpty(categoryAttributeResponses)) {
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.categoryAttribute.CATEGORY_ATTRIBUTE_DATA_EMPTY.getMsg(), DataResponse.dataResponse(categoryAttributeResponses, 0L));
        }
        PageInfo<CategoryAttributeResponse> pageInfo = new PageInfo<>(categoryAttributeResponses);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.categoryAttribute.CATEGORY_ATTRIBUTE_GET_SUCCESS.getMsg(), DataResponse.dataResponse(pageInfo.getList(), pageInfo.getTotal()));
    }

    /**
     * 添加分类属性
     *
     * @param categoryAttributeAddRequest
     * @return
     */
    @Override
    @Transactional
    public FCResponse<Void> addCategoryAttribute(CategoryAttributeAddRequest categoryAttributeAddRequest) {
        // 判断是否有重复属性
        long count = categoryAttributeAddRequest.getAttributes().stream().distinct().count();
        if (categoryAttributeAddRequest.getAttributes().size() != count){
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(),HttpMsg.categoryAttribute.CATEGORY_ATTRIBUTE_DATA_REPEAT.getMsg());
        }
        // 循环添加属性
        categoryAttributeAddRequest.getAttributes().forEach(name -> {
            Attribute attribute = new Attribute();
            attribute.setId(IDGeneratorUtil.getNextId());
            attribute.setName(name);
            attribute.setCategoryId(categoryAttributeAddRequest.getCategoryId());
            attribute.setCreateTime(new Date());
            attribute.setUpdateTime(attribute.getCreateTime());
            this.attributeMapper.addAttribute(attribute);
            // 添加中间表中
            CategoryAttribute categoryAttribute = new CategoryAttribute();
            categoryAttribute.setId(IDGeneratorUtil.getNextId());
            categoryAttribute.setCategoryId(categoryAttributeAddRequest.getCategoryId());
            categoryAttribute.setAttributeId(attribute.getId());
            categoryAttribute.setCreateTime(new Date());
            categoryAttribute.setUpdateTime(categoryAttribute.getCreateTime());
            this.categoryAttributeMapper.addCategoryAttribute(categoryAttribute);
        });
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.categoryAttribute.CATEGORY_ATTRIBUTE_ADD_SUCCESS.getMsg());
    }


    /**
     * 查询该分类的状态
     *
     * @param categoryId
     * @return
     */
    @Override
    public FCResponse<Void> getCategoryStatus(Long categoryId) {
        if (ObjectUtils.isEmpty(categoryId) || categoryId <= 0){
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(),HttpMsg.category.CATEGORY_ID_ERROR.getMsg());
        }
        Integer count = this.categoryAttributeMapper.getCategoryStatus(categoryId);
        if (count > 0){
            return FCResponse.dataResponse(HttpFcStatus.DATAEXIST.getCode(),HttpMsg.category.CATEGORY_ATTRIBUTE_SET.getMsg());
        }
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.categoryAttribute.CATEGORY_ATTRIBUTE_ADD_ATTRIBUTE.getMsg());
    }

    /**
     * 查询已设置的分类属性
     *
     * @return
     */
    @Override
    public FCResponse<List<CategoryAttributeResponse>> getCategoryAttribute() {
        List<CategoryAttributeResponse> categoryAttributeResponses = this.categoryAttributeMapper.getCategoryAttribute();
        if (CollectionUtils.isEmpty(categoryAttributeResponses)){
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.categoryAttribute.CATEGORY_ATTRIBUTE_DATA_EMPTY.getMsg());
        }
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.categoryAttribute.CATEGORY_ATTRIBUTE_GET_SUCCESS.getMsg(),categoryAttributeResponses);
    }
}
