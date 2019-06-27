package com.xiazhe.service;

import com.xiazhe.bean.Department;
import org.apache.ibatis.annotations.Param;

public interface DepartmentService {
    public int addDepartment(@Param("depart") Department department);
    public int deleteDepartments(@Param("ids")String[] ids);
    public int updateDepartment(@Param("depart")Department department);
    public Department queryDepartmentById(@Param("id")String id);
    public Department[] queryDepartmentsById(@Param("id")String id);
    public Department[] queryDepartmentsByName(@Param("name")String name);
    public Department[] queryAllDepartments();
}
