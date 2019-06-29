package com.xiazhe.controller.TechnologyController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.Process;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.Technology;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.technologyService.ProcessService;
import com.xiazhe.service.technologyService.TechnologyPlanService;
import com.xiazhe.service.technologyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("process")
public class ProcessController {
    @Autowired
    ProcessService processService;
    @Autowired
    TechnologyService technologyService;
    @Autowired
    TechnologyPlanService technologyPlanService;

    //显示工序管理列表
    @RequestMapping("/find")
    public String toProcessList(HttpSession httpSession){


        return "/WEB-INF/jsp/process_list.jsp";
    }
    //分页操作
    @RequestMapping("/list")
    @ResponseBody
    public QueryJsonBean<Process> queryAllTechnology(int page, int rows){
        PageHelper pageHelper = new PageHelper();
        Page<Process> processpage = pageHelper.startPage(page, rows);
        List<Process> processes = processService.queryAllProcess();
        QueryJsonBean<Process> processQueryJsonBean = new QueryJsonBean<>();
        processQueryJsonBean.setRows(processes);
        processQueryJsonBean.setTotal((int) processpage.getTotal());
        return processQueryJsonBean;
    }


    //通过id进行模糊查询
    @RequestMapping("/search_process_by_processId")
    @ResponseBody
    public Process[] selectByIdAm(String searchValue){
        Process[] processes = processService.selectByPrimaryKey(searchValue);
        return processes;
    }
    //通过工艺计划id模糊查询
    @RequestMapping("/search_process_by_technologyPlanId")
    @ResponseBody
    public Process[] selectByName(String searchValue){
        Process[] processes = processService.selectByName(searchValue);
        return processes;
    }
    //
    /*增加工序*/
    //跳转至增加页面
    @RequestMapping("add_judge")
    public String toAddjudge(){
        return "/WEB-INF/jsp/process_add.jsp";
    }
    @RequestMapping("add")
    public String toAdd(){
        return "/WEB-INF/jsp/process_add.jsp";
    }
    //增加工艺操作
    @RequestMapping("insert")
    @ResponseBody
    public Result insert(Process process){
        processService.insert(process);
        Result result = new Result();
        result.setData(null);
        result.setMsg("Ok");
        result.setStatus(200);
        return result;
    }

    /*工序修改*/
    //跳转至修改界面
    @RequestMapping("edit_judge")
    public String toEditjudge(){
        return "/WEB-INF/jsp/process_edit.jsp";
    }
    @RequestMapping("edit")
    public String toEdit(){
        return "/WEB-INF/jsp/process_edit.jsp";
    }

    //修改工艺操作
    @RequestMapping("update_all")
    @ResponseBody
    public Result edit(Process process){
        processService.updateByPrimaryKey(process);
        Result result = new Result();
        result.setData(null);
        result.setMsg("Ok");
        result.setStatus(200);
        return result;
    }

    /*工序删除操作*/
    //跳转至删除页面
    @RequestMapping("delete_judge")
    public String todeletejudge(){
        return "/WEB-INF/jsp/process_list.jsp";
    }
    //批量删除操作
    @RequestMapping("delete_batch")
    @ResponseBody
    public Result delete(String[] ids){//参数名称要与前端传来的一样，mapper层注解也是
        processService.deleteByPrimaryKey(ids);
        Result result = new Result();
        result.setData(null);
        result.setMsg("Ok");
        result.setStatus(200);
        return result;
    }

    /**
     *@author: Draven
     *@date: 2019/6/28
     *@description: 获取process的数据
     *@param:
     *@return: 返回processlist
     */
    @RequestMapping("get_data")
    @ResponseBody
    public List<Process> getProcessData(){
       return processService.queryAllProcess();
    }
}
