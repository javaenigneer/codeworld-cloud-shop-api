package com.codeworld.fc.system.dept.domain;



import com.codeworld.fc.system.dept.entity.Dept;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * ClassName DeptTreeNode
 * Description TODO
 * Author Lenovo
 * Date 2020/10/13
 * Version 1.0
**/
@Data
public class DeptTreeNode extends Dept {

    List<DeptTreeNode> children = Lists.newArrayList();
}

