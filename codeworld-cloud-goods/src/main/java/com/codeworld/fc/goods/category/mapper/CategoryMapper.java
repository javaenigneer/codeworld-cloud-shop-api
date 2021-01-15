package com.codeworld.fc.goods.category.mapper;


import com.codeworld.fc.goods.category.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {


    /**
     * 获取全部分类
     * @return
     */
    List<Category> getAllCategory();

    /**
     * 添加分类
     * @param category
     */
    void addCategory(Category category);

    /**
     * 修改分类
     * @param category
     */
    void updateCategory(Category category);

    /**
     * 根据分类Id获取子集分类
     * @param categoryId
     * @return
     */
    List<Category> getChildCategoryById(Long categoryId);

    /**
     * 根据分类id查询分类信息
     * @param categoryId
     * @return
     */
    Category getCategoryById(Long categoryId);
}
