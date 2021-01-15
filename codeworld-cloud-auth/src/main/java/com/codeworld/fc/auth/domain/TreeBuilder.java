package com.codeworld.fc.auth.domain;


import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ClassName TreeBuilder
 * Description 树构造工具类
 * Author Lenovo
 * Date 2020/8/26
 * Version 1.0
 **/
public class TreeBuilder {

    public static List<MenuTreeNode> buildMenuTree(List<MenuTreeNode> allNodes) {
        // 根节点
        List<MenuTreeNode> root = Lists.newArrayList();
        allNodes.forEach(node -> {
            if (node.getParentId() == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findMenuChildren(node, allNodes);
        });

        //对根节点排序
        List<MenuTreeNode> sortedList = root.stream().sorted(Comparator.comparing(MenuTreeNode::getSortNo)).collect(Collectors.toList());
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
    private static MenuTreeNode findMenuChildren(MenuTreeNode treeNode, List<MenuTreeNode> treeNodes) {
        for (MenuTreeNode it : treeNodes) {
            if (treeNode.getId().longValue() == it.getParentId().longValue()) {
                treeNode.getChildren().add(findMenuChildren(it, treeNodes));
            }
        }
        //对子节点排序
        List<MenuTreeNode> childrenSorted = treeNode.getChildren().stream().sorted(Comparator.comparing(MenuTreeNode::getSortNo)).collect(Collectors.toList());
        //先清空，在添加
        treeNode.getChildren().clear();
        treeNode.getChildren().addAll(childrenSorted);
        return treeNode;
    }

    public static Set<MenuVO> buildTree(Set<MenuVO> allNodes) {
        // 根节点
        Set<MenuVO> root = new HashSet<>();
        allNodes.forEach(node -> {
            if (Integer.valueOf( node.getParentId() ) == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findChildren(node, allNodes);
        });
        return root;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private static MenuVO findChildren(MenuVO treeNode, Set<MenuVO> treeNodes) {
        for (MenuVO it : treeNodes) {
            if (String.valueOf( treeNode.getId() ).equals(it.getParentId())) {
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

}
