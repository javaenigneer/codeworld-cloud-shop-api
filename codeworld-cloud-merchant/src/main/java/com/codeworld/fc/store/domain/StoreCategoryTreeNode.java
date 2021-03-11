package com.codeworld.fc.store.domain;

import com.codeworld.fc.store.entity.StoreCategory;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * ClassName StoreCategoryTreeNode
 * Description TODO
 * Author Lenovo
 * Date 2021/3/10
 * Version 1.0
**/
@Data
public class StoreCategoryTreeNode extends StoreCategory {
    List<StoreCategoryTreeNode> children = Lists.newArrayList();
}
