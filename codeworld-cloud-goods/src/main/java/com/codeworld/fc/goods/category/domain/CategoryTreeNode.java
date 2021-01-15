package com.codeworld.fc.goods.category.domain;

import com.codeworld.fc.goods.category.entity.Category;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * ClassName CategoryTreeNode
 * Description TODO
 * Author Lenovo
 * Date 2020/11/27
 * Version 1.0
**/
@Data
public class CategoryTreeNode extends Category {

    List<CategoryTreeNode> children = Lists.newArrayList();
}
