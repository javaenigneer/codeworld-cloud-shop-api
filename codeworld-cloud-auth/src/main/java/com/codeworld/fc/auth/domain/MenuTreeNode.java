package com.codeworld.fc.auth.domain;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * ClassName MenuTreeNode
 * Description TODO
 * Author Lenovo
 * Date 2020/8/26
 * Version 1.0
**/
@Data
public class MenuTreeNode extends Menu {

    List<MenuTreeNode> children = Lists.newArrayList();
}
