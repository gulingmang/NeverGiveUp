package com.xiazhe.controller.EmployyeeController;

import com.xiazhe.bean.Department;
import com.xiazhe.bean.Employee;
import com.xiazhe.service.DepartmentService.DepartmentService;
import com.xiazhe.service.EmployeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeGetData {
    @Autowired
    EmployeeService service;

    @RequestMapping("employee/get_data")
    @ResponseBody
    public List<Employee> getdata() {
        List<Employee> list = service.getList();
        return list;
    }

}
