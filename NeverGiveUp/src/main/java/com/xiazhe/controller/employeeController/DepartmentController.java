
package com.xiazhe.controller.employeeController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiazhe.bean.Department;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.json.QueryJsonBean;

import com.xiazhe.service.DepartmentService.DepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartMentService departmentService;
    /*跳转到列表的jsp页面*/
    @RequestMapping("/find")
    public String showDepartmentPage(){
        return "/WEB-INF/jsp/department_list.jsp";
    }

    /*显示所有的部门*/
    @RequestMapping("/list")
    @ResponseBody
    public QueryJsonBean<Department> listDepartment(Integer page, Integer rows){
        PageHelper pageHelper=new PageHelper();
        Page<Department> resultPage = PageHelper.startPage(page, rows);
        List<Department> departments = Arrays.asList(departmentService.queryAllDepartments());
        QueryJsonBean<Department> departmentQueryJsonBean = new QueryJsonBean<>();
        departmentQueryJsonBean.setTotal((int)resultPage.getTotal());
        departmentQueryJsonBean.setRows(departments);
        return departmentQueryJsonBean;
    }

    /*新增操作判断*/
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addJudge(){
        return "{}";
    }

    /*显示新增部门页面*/
    @RequestMapping("/add")
    public String showAddDepartmentPage(){
        return "/WEB-INF/jsp/department_add.jsp";
    }

    /*新增部门*/
    @RequestMapping("/insert")
    @ResponseBody
    public Result addDepartment(String departmentId,String departmentName,String note){
        departmentService.addDepartment(new Department(departmentId,departmentName,note));
        return new Result(200,"OK",null);
    }

    /*修改操作判断*/
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editJudge(){
        return "{}";
    }

    /*显示修改部门页面*/
    @RequestMapping("/edit")
    public String showEditDepartmentPage(){
        return "/WEB-INF/jsp/department_edit.jsp";
    }

    /*修改部门*/
    @RequestMapping("/update_all")
    @ResponseBody
    public Result editDepartment(String departmentId,String departmentName,String note){
        departmentService.updateDepartment(new Department(departmentId,departmentName,note));
        return new Result(200,"OK",null);
    }

    /*删除操作判断*/
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteJudge(){
        return "{}";
    }

    /*删除部门*/
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Result deleteDepartments(String[] ids){
        departmentService.deleteDepartments(ids);
        return new Result(200,"OK",null);
    }

    /*根据不同条件查找部门*/
    @RequestMapping({"/search_department_by_departmentId","/search_department_by_departmentName"})
    @ResponseBody
    public QueryJsonBean<Department> queryDepartmentsById(String searchValue, int page, int rows, HttpServletRequest request){
        PageHelper pageHelper=new PageHelper();
        List<Department> departments = null;
        Page<Department> resultPage = PageHelper.startPage(page, rows);
        //根据id或name进行相应的查找
        if (request.getRequestURI().contains("departmentId")) departments=Arrays.asList(departmentService.queryDepartmentsById(searchValue));
        if (request.getRequestURI().contains("departmentName")) departments=Arrays.asList(departmentService.queryDepartmentsByName(searchValue));
        QueryJsonBean<Department> departmentQueryJsonBean = new QueryJsonBean<>();
        departmentQueryJsonBean.setTotal((int)resultPage.getTotal());
        departmentQueryJsonBean.setRows(departments);
        return departmentQueryJsonBean;
    }
}
