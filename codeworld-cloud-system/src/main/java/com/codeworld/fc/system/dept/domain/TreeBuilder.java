package com.codeworld.fc.system.dept.domain;



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


    public static List<DeptTreeNode> buildDeptTree(List<DeptTreeNode> deptTreeNodeList) {

        // 根节点
        List<DeptTreeNode> root = Lists.newArrayList();
        deptTreeNodeList.forEach(node -> {
            if (node.getParentId() == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findDeptChildren(node, deptTreeNodeList);
        });

        //对根节点排序
        List<DeptTreeNode> sortedList = root.stream().sorted(Comparator.comparing(DeptTreeNode::getSortNo)).collect(Collectors.toList());
        //先清空，在添加
        root.clear();
        root.addAll(sortedList);
        return root;
    }

    /**
     * 递归查找子节点--部门
     *
     * @param treeNodes
     * @return
     */
    private static DeptTreeNode findDeptChildren(DeptTreeNode treeNode, List<DeptTreeNode> treeNodes) {
        for (DeptTreeNode it : treeNodes) {
            if (treeNode.getId().longValue() == it.getParentId().longValue()) {
                treeNode.getChildren().add(findDeptChildren(it, treeNodes));
            }
        }
        //对子节点排序
        List<DeptTreeNode> childrenSorted = treeNode.getChildren().stream().sorted(Comparator.comparing(DeptTreeNode::getSortNo)).collect(Collectors.toList());
        //先清空，在添加
        treeNode.getChildren().clear();
        treeNode.getChildren().addAll(childrenSorted);
        return treeNode;
    }
}
