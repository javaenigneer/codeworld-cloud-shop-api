package com.codeworld.fc.store.domain;


import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName TreeBuilder
 * Description 树构造工具类
 * Author Lenovo
 * Date 2020/8/26
 * Version 1.0
 **/
public class TreeBuilder {

    public static List<StoreCategoryTreeNode> buildStoreCategoryTree(List<StoreCategoryTreeNode> allNodes) {
        // 根节点
        List<StoreCategoryTreeNode> root = Lists.newArrayList();
        allNodes.forEach(node -> {
            if (node.getParentId() == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findCategoryChildren(node, allNodes);
        });

        //对根节点排序
        List<StoreCategoryTreeNode> sortedList = root.stream().sorted(Comparator.comparing(StoreCategoryTreeNode::getSortNo)).collect(Collectors.toList());
        //先清空，在添加
        root.clear();
        root.addAll(sortedList);
        return root;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private static StoreCategoryTreeNode findCategoryChildren(StoreCategoryTreeNode treeNode, List<StoreCategoryTreeNode> treeNodes) {
        for (StoreCategoryTreeNode it : treeNodes) {
            if (treeNode.getId().longValue() == it.getParentId().longValue()) {
                treeNode.getChildren().add(findCategoryChildren(it, treeNodes));
            }
        }
        //对子节点排序
        List<StoreCategoryTreeNode> childrenSorted = treeNode.getChildren().stream().sorted(Comparator.comparing(StoreCategoryTreeNode::getSortNo)).collect(Collectors.toList());
        //先清空，在添加
        treeNode.getChildren().clear();
        treeNode.getChildren().addAll(childrenSorted);
        return treeNode;
    }
}
