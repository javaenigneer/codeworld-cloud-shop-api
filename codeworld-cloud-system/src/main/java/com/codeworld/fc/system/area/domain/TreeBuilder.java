package com.codeworld.fc.system.area.domain;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName TreeBuilder
 * Description 树构造工具类
 * Author Lenovo
 * Date 2021/1/29
 * Version 1.0
**/
@Slf4j
public class TreeBuilder {

    public static List<AreaTreeNode> buildAreaTree(List<AreaTreeNode> allNodes) {
        // 根节点
        List<AreaTreeNode> root = Lists.newArrayList();
        allNodes.forEach(node -> {

            if (node.getParentId() == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findCategoryChildren(node, allNodes);
        });

        //对根节点排序
        List<AreaTreeNode> sortedList = root.stream().sorted(Comparator.comparing(AreaTreeNode::getSortNo)).collect(Collectors.toList());
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
    private static AreaTreeNode findCategoryChildren(AreaTreeNode treeNode, List<AreaTreeNode> treeNodes) {
        for (AreaTreeNode it : treeNodes) {
            if (treeNode.getId().longValue() == it.getParentId().longValue()) {
                treeNode.getChildren().add(findCategoryChildren(it, treeNodes));
            }
        }
        //对子节点排序
        List<AreaTreeNode> childrenSorted = treeNode.getChildren().stream().sorted(Comparator.comparing(AreaTreeNode::getSortNo)).collect(Collectors.toList());
        //先清空，在添加
        treeNode.getChildren().clear();
        treeNode.getChildren().addAll(childrenSorted);
        return treeNode;
    }
}
