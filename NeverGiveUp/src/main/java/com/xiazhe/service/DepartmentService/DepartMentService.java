package com.xiazhe.service.DepartmentService;

import com.xiazhe.bean.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartMentService {
    public int addDepartment(Department department);
    public int deleteDepartments(String[] ids);
    public int updateDepartment(Department department);
    public int countAllDepartments();
    public Department queryDepartmentById(String id);
    public Department[] queryDepartmentsById(String id);
    public Department[] queryDepartmentsByName(String name);
    public Department[] queryAllDepartments();
    public List<Department> getList();
}
