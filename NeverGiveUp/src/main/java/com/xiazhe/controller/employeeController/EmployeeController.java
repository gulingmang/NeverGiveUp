package com.xiazhe.controller.employeeController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.*;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.DepartmentService.DepartmentService;
import com.xiazhe.service.EmployeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /*封装员工bean*/
    private Employee getEmployeeBean(String empId,String empName,String sex,String departmentId,String idCode,String education,String degree,String educationForm,String birthday,String joinDate,String status,String major){
        Employee employee = new Employee();
        employee.setEmpId(empId);
        employee.setEmpName(empName);
        employee.setSex(sex);
        employee.setDepartmentId(departmentId);
        employee.setIdCode(idCode);
        employee.setEducation(education);
        employee.setDegree(degree);
        employee.setEducationForm(educationForm);
        employee.setStatus(status);
        employee.setMajor(major);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            if (birthday!=null&&!"".equals(birthday)) employee.setBirthday(simpleDateFormat.parse(birthday));
            if (joinDate!=null&&!"".equals(joinDate)) employee.setJoinDate(simpleDateFormat.parse(joinDate));
        }catch (ParseException e){
            e.printStackTrace();
        }
        return employee;
    }

    /*操作判断*/
    @RequestMapping("/*_judge")
    @ResponseBody
    public String judge(){
        return "{}";
    }

    /*员工列表页面*/
    @RequestMapping("/find")
    public String showEmployeeListPage(){
        return "/WEB-INF/jsp/employee_list.jsp";
    }

    /*所有员工列表数据*/
    @RequestMapping("/list")
    @ResponseBody
    public QueryJsonBean allEmployeeListData(int page,int rows){
        PageHelper pageHelper=new PageHelper();
        Page<Department> resultPage = PageHelper.startPage(page, rows);
        List<EmployeeDepartmentUnion> employeesAndDepartment = employeeService.queryAllEmployeesAndDepartment();
        QueryJsonBean<EmployeeDepartmentUnion> departmentQueryJsonBean = new QueryJsonBean<>();
        departmentQueryJsonBean.setTotal((int)resultPage.getTotal());
        departmentQueryJsonBean.setRows(employeesAndDepartment);
        return departmentQueryJsonBean;
    }

    /*显示添加员工页面*/
    @RequestMapping("/add")
    public String showEmployeeAddPage(){
        return "/WEB-INF/jsp/employee_add.jsp";
    }

    /*插入员工*/
    @RequestMapping("/insert")
    @ResponseBody
    public Result addEmployee(String empId,String empName,String sex,String departmentId,String idCode,String education,String degree,String educationForm,String birthday,String joinDate,String status,String major){
        Employee employee = getEmployeeBean(empId, empName, sex, departmentId, idCode, education, degree, educationForm, birthday, joinDate, status, major);
        employeeService.insert(employee);
        return new Result(200,"OK",null);
    }

    /*显示编辑员工页面*/
    @RequestMapping("/edit")
    public String showEmployeeEditPage(){
        return "/WEB-INF/jsp/employee_edit.jsp";
    }

    /*更改员工数据*/
    @RequestMapping("/update_all")
    @ResponseBody
    public Result editEmployee(String empId,String empName,String sex,String departmentId,String idCode,String education,String degree,String educationForm,String birthday,String joinDate,String status,String major){
        Employee employee = getEmployeeBean(empId, empName, sex, departmentId, idCode, education, degree, educationForm, birthday, joinDate, status, major);
        employeeService.updateByPrimaryKey(employee);
        return new Result(200,"OK",null);
    }

    /*批量删除员工*/
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Result deleteEmployees(String[] ids){
        employeeService.deleteEmployeesByIds(ids);
        return new Result(200,"OK",null);
    }

    /*根据不同条件查找员工*/
    @RequestMapping({"/search_employee_by_employeeId","/search_employee_by_employeeName","/search_employee_by_departmentName"})
    @ResponseBody
    public QueryJsonBean<EmployeeDepartmentUnion> queryEmployee(String searchValue, int page, int rows, HttpServletRequest request){
        PageHelper pageHelper=new PageHelper();
        List<EmployeeDepartmentUnion> departments = null;
        Page<EmployeeDepartmentUnion> resultPage = PageHelper.startPage(page, rows);
        //根据id或，name或部门进行相应的查找
        if (request.getRequestURI().contains("employeeId")) departments=employeeService.queryEmployeesAndDepartmentById(searchValue);
        if (request.getRequestURI().contains("employeeName")) departments=employeeService.queryEmployeesAndDepartmentByEmpName(searchValue);
        if (request.getRequestURI().contains("departmentName")) departments=employeeService.queryEmployeesAndDepartmentByDepName(searchValue);
        QueryJsonBean<EmployeeDepartmentUnion> departmentQueryJsonBean = new QueryJsonBean<>();
        departmentQueryJsonBean.setTotal((int)resultPage.getTotal());
        departmentQueryJsonBean.setRows(departments);
        return departmentQueryJsonBean;
    }

    //rest风格查询员工信息
    @RequestMapping(value = "/get/{employeeId}",method = RequestMethod.GET)
    @ResponseBody
    public EmployeeDepartmentUnion queryTechnologyById(@PathVariable String employeeId){
        EmployeeDepartmentUnion employeeDepartmentUnion = employeeService.selectOneById(employeeId);
        return employeeDepartmentUnion;
    }
}
