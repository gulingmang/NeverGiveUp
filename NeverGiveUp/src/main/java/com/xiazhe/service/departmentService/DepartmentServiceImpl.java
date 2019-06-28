package com.xiazhe.service.DepartmentService;

import com.xiazhe.bean.Department;
import com.xiazhe.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartMentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> getList() {
        List<Department> list = departmentMapper.getList();
        return list;
    }

    public int addDepartment(Department department) {
        return departmentMapper.addDepartment(department);
    }

    public int deleteDepartments(String[] ids) {
        return departmentMapper.deleteDepartments(ids);
    }

    public int updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    public Department queryDepartmentById(String id) {
        return departmentMapper.queryDepartmentById(id);
    }

    public Department[] queryDepartmentsById(String id) {
        return departmentMapper.queryDepartmentsById(id);
    }

    public Department[] queryDepartmentsByName(String name) {
        return departmentMapper.queryDepartmentsByName(name);
    }

    public Department[] queryAllDepartments() {
        return departmentMapper.queryAllDepartments();
    }

}