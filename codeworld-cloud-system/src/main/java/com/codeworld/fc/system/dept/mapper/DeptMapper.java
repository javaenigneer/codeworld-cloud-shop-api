package com.codeworld.fc.system.dept.mapper;


import com.codeworld.fc.system.dept.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {


    /**
     * 获取部门树
     * @return
     */
    List<Dept> getAllDept();

    /**
     * 添加部门
     * @param dept
     */
    void addDept(Dept dept);

    /**
     * 修改部门
     * @param dept
     */
    void updateDept(Dept dept);
}
