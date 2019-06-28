package com.xiazhe.mapper;

import com.xiazhe.bean.Employee;
import com.xiazhe.bean.EmployeeDepartmentUnion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(String empId);
    /*插入数据*/
    int insert(Employee record);
    int insertSelective(Employee record);
    Employee selectByPrimaryKey(String empId);
    int updateByPrimaryKeySelective(Employee record);
    /*更新数据*/
    int updateByPrimaryKey(Employee record);
    List<Employee>getList();
    /*所有员工及其部门的列表*/
    List<EmployeeDepartmentUnion> queryAllEmployeesAndDepartment();
    /*根据员工id进行模糊查询*/
    List<EmployeeDepartmentUnion> queryEmployeesAndDepartmentById(@Param("empId") String empId);
    /*根据员工姓名进行模糊查询*/
    List<EmployeeDepartmentUnion> queryEmployeesAndDepartmentByEmpName(@Param("empName") String empName);
    /*根据部门名称进行模糊查询*/
    List<EmployeeDepartmentUnion> queryEmployeesAndDepartmentByDepName(@Param("depName") String depName);
    /*根据员工id批量删除员工*/
    int deleteEmployeesByIds(@Param("ids")String[] ids);
}