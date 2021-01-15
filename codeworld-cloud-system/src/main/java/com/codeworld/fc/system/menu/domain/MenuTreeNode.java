package com.codeworld.fc.system.menu.domain;



import com.codeworld.fc.system.menu.entity.Menu;
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
