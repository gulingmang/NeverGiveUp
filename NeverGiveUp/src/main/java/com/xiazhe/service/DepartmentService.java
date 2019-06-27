package com.xiazhe.service;

import com.xiazhe.bean.Department;
import com.xiazhe.bean.UnQualifyApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentService {
    public int addDepartment(@Param("depart") Department department);
    public int deleteDepartments(@Param("ids")String[] ids);
    public int updateDepartment(@Param("depart")Department department);
    public Department queryDepartmentById(@Param("id")String id);
    public Department[] queryDepartmentsById(@Param("id")String id);
    public Department[] queryDepartmentsByName(@Param("name")String name);
    public List<UnQualifyApply> queryPageDepartments(int offset, int limit);
}
