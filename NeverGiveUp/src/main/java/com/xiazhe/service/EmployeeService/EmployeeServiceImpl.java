package com.xiazhe.service.EmployeeService;

import com.xiazhe.bean.Employee;
import com.xiazhe.bean.EmployeeDepartmentUnion;
import com.xiazhe.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper mymapper;

    @Override
    public List<Employee> getList() {
        List<Employee> list = mymapper.getList();
        return list;
    }

    @Override
    public int insert(Employee record) {
        return mymapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Employee record) {
        return mymapper.updateByPrimaryKey(record);
    }

    @Override
    public List<EmployeeDepartmentUnion> queryAllEmployeesAndDepartment() {
        return mymapper.queryAllEmployeesAndDepartment();
    }

    @Override
    public List<EmployeeDepartmentUnion> queryEmployeesAndDepartmentById(String empId) {
        return mymapper.queryEmployeesAndDepartmentById(empId);
    }

    @Override
    public List<EmployeeDepartmentUnion> queryEmployeesAndDepartmentByEmpName(String empName) {
        return mymapper.queryEmployeesAndDepartmentByEmpName(empName);
    }

    @Override
    public List<EmployeeDepartmentUnion> queryEmployeesAndDepartmentByDepName(String depName) {
        return mymapper.queryEmployeesAndDepartmentByDepName(depName);
    }

    @Override
    public int deleteEmployeesByIds(String[] ids) {
        return mymapper.deleteEmployeesByIds(ids);
    }

    @Override
    public EmployeeDepartmentUnion selectOneById(String empId) {
        return mymapper.selectOneById(empId);
    }
}
