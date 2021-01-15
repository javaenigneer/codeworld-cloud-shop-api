package com.codeworld.fc.goods.category.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.codeworld.fc.common.enums.HttpFcStatus;
import com.codeworld.fc.common.enums.HttpMsg;
import com.codeworld.fc.common.exception.FCException;
import com.codeworld.fc.common.response.FCResponse;
import com.codeworld.fc.common.utils.IDGeneratorUtil;
import com.codeworld.fc.common.utils.JsonUtils;
import com.codeworld.fc.goods.attribute.entity.Attribute;
import com.codeworld.fc.goods.attribute.mapper.AttributeMapper;
import com.codeworld.fc.goods.category.domain.TreeBuilder;
import com.codeworld.fc.goods.category.domain.CategoryTreeNode;
import com.codeworld.fc.goods.category.entity.Category;
import com.codeworld.fc.goods.category.mapper.CategoryMapper;
import com.codeworld.fc.goods.category.request.CategoryRequest;
import com.codeworld.fc.goods.category.service.CategoryService;
import com.codeworld.fc.goods.param.mapper.ParamMapper;
import com.codeworld.fc.goods.product.mapper.ProductMapper;
import com.google.common.collect.Lists;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName CategoryServiceImpl
 * Description TODO
 * Author Lenovo
 * Date 2020/11/27
 * Version 1.0
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired(required = false)
    private CategoryMapper categoryMapper;
    @Autowired(required = false)
    private AttributeMapper attributeMapper;
    @Autowired(required = false)
    private ParamMapper paramMapper;
    @Autowired(required = false)
    private ProductMapper productMapper;

    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;
    private final String CATEGORY_LIST = "category_list";

    /**
     * 获取全部分类
     *
     * @return
     */
    public FCResponse<Object> treeCategory() {
        List<Category> categories = this.categoryMapper.getAllCategory();
        final List<CategoryTreeNode> categoryTreeNodes = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(categories)) {
            categories.forEach(category -> {
                CategoryTreeNode categoryTreeNode = new CategoryTreeNode();
                BeanUtils.copyProperties(category, categoryTreeNode);
                categoryTreeNodes.add(categoryTreeNode);
            });
        }
        List<CategoryTreeNode> newCategoryTreeNodeList = TreeBuilder.buildCategoryTree(categoryTreeNodes);
        newCategoryTreeNodeList.stream().sorted(Comparator.comparing(CategoryTreeNode::getSortNo)).collect(Collectors.toList());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("categoryList", categories);
        jsonObject.put("categoryTree", newCategoryTreeNodeList);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.menu.MENU_GET_SUCCESS.getMsg(), jsonObject);
    }

    /**
     * 添加分类
     *
     * @param categoryRequest
     * @return
     */
    @Override
    public FCResponse<Void> addCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        BeanUtil.copyProperties(categoryRequest, category);
        category.setId(IDGeneratorUtil.getNextId());
        category.setCreateTime(new Date());
        category.setUpdateTime(category.getCreateTime());
        this.categoryMapper.addCategory(category);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.category.CATEGORY_ADD_SUCCESS.getMsg());
    }

    /**
     * 编辑分类
     *
     * @param categoryRequest
     * @return
     */
    @Override
    public FCResponse<Void> updateCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        BeanUtil.copyProperties(categoryRequest, category);
        category.setUpdateTime(new Date());
        this.categoryMapper.updateCategory(category);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.category.CATEGORY_UPDATE_SUCCESS.getMsg());
    }

    /**
     * 获取全部分类
     *
     * @return
     */
    @Override
    public FCResponse<List<Category>> getAllCategory() {
        try {
            // 先从redis中获取
            if (this.stringRedisTemplate.hasKey(CATEGORY_LIST)) {
                String categoryJson = this.stringRedisTemplate.opsForValue().get(CATEGORY_LIST);
                List<Category> categories = JsonUtils.parseList(categoryJson, Category.class);
                return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.category.CATEGORY_GET_SUCCESS.getMsg(), categories);
            }
            // 没有则从数据库中获取
            List<Category> categories = this.categoryMapper.getAllCategory();
            if (CollectionUtils.isEmpty(categories)) {
                return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.category.CATEGORY_DATA_EMPTY.getMsg(), null);
            }
            // 将数据装换成Json保存到redis中
            String categoryJson = JsonUtils.serialize(categories);
            this.stringRedisTemplate.opsForValue().set(CATEGORY_LIST, categoryJson);
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.category.CATEGORY_GET_SUCCESS.getMsg(), categories);
        } catch (Exception e) {
            e.printStackTrace();
            throw new FCException("系统错误");
        }
    }


    /**
     * 删除分类
     *
     * @param categoryId
     * @return
     */
    @Override
    public FCResponse<Void> deleteCategory(Long categoryId) {
        if (ObjectUtil.isEmpty(categoryId) || categoryId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.category.CATEGORY_ID_ERROR.getMsg());
        }
        // 先根据分类id查询该分类是否绑定商品
        Integer count = this.productMapper.getBindProductByCategoryId(categoryId);
        if (count != 0) {
            return FCResponse.dataResponse(HttpFcStatus.DATAEXIST.getCode(), HttpMsg.category.CATEGORY_BIND_PRODUCT.getMsg());
        }
        // count == 0无关联，可以删除
        // 根据分类id查询是否有子集分类
        List<Category> categories = this.categoryMapper.getChildCategoryById(categoryId);
        if (!CollectionUtils.isEmpty(categories)) {
            categories.forEach(category -> {
                // 根据分类id查询属性
                List<Long> attributeIds = this.attributeMapper.getAttributeIdsByCategoryId(category.getId());
                if (!CollectionUtils.isEmpty(attributeIds)) {
                    // 删除该属性下的所有参数
                    this.paramMapper.deleteParamByAttributeIds(attributeIds);
                }
            });
        }
        //TODO
        return null;
    }

    /**
     * 根据分类id获取分类信息
     *
     * @param categoryId
     * @return
     */
    @Override
    public FCResponse<Category> getCategoryById(Long categoryId) {
        if (ObjectUtil.isEmpty(categoryId) || categoryId <= 0) {
            return FCResponse.dataResponse(HttpFcStatus.PARAMSERROR.getCode(), HttpMsg.category.CATEGORY_ID_ERROR.getMsg());
        }
        Category category = this.categoryMapper.getCategoryById(categoryId);
        return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(), HttpMsg.category.CATEGORY_GET_SUCCESS.getMsg(), category);
    }

    /**
     * 获取父级分类-app
     *
     * @return
     */
    @Override
    public FCResponse<List<Category>> getParentCategory() {
        // 从Redis中获取
        if (this.stringRedisTemplate.hasKey(CATEGORY_LIST)){
            String json = this.stringRedisTemplate.opsForValue().get(CATEGORY_LIST);
            assert json != null;
            List<Category> categories = JsonUtils.parseList(json, Category.class);
            // 返回parentId为0的分类数据
            categories =categories.stream().filter(category -> {
                 return category.getParentId() == 0L;
            }).collect(Collectors.toList());
            return FCResponse.dataResponse(HttpFcStatus.DATASUCCESSGET.getCode(),HttpMsg.category.CATEGORY_GET_SUCCESS.getMsg(),categories);
        }
        return FCResponse.dataResponse(HttpFcStatus.DATAEMPTY.getCode(),HttpMsg.category.CATEGORY_DATA_EMPTY.getMsg());
    }
}
