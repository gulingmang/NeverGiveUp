/*
package com.xiazhe.controller;

import com.xiazhe.bean.Department;
import com.xiazhe.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    */
/*跳转到jsp页面*//*

    @RequestMapping("/find")
    public String showDepartmentPage(){
        return "/WEB-INF/jsp/department_list.jsp";
    }

    */
/*显示所有的部门*//*

    @RequestMapping("/list")
    @ResponseBody
    public Department[] listDepartment(){
        return departmentService.queryAllDepartments();
    }

    */
/*新增部门*//*

    @RequestMapping("/insert")
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    */
/*修改部门*//*

    @RequestMapping("/update_all")
    public void editDepartment(String departmentId,String departmentName,String note){
        departmentService.addDepartment(new Department(departmentId,departmentName,note));
    }
}
*/
