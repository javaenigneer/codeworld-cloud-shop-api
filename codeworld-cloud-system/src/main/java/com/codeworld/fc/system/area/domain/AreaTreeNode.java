package com.codeworld.fc.system.area.domain;

import com.codeworld.fc.system.area.entity.Area;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * ClassName AreaTreeNode
 * Description TODO
 * Author Lenovo
 * Date 2021/1/29
 * Version 1.0
**/
@Data
public class AreaTreeNode extends Area {

    List<AreaTreeNode> children = Lists.newArrayList();
}
