package com.xiazhe.controller.plan;


import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.Task;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.plan.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("task")
public class ManagerTaskPlan {

    @Autowired
    TaskServices taskServices;

    @RequestMapping("find")
    public String task(){
        return "/WEB-INF/jsp/task_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryJsonBean<Task> getTaskList(int page, int rows){
        QueryJsonBean<Task> queryJsonBean = taskServices.queryTasks(page, rows);
        return queryJsonBean;
    }

    @RequestMapping("/*_judge")
    @ResponseBody
    public String taskJudge(){
        return null;
    }

    @RequestMapping("add")
    public String add(){
        return "/WEB-INF/jsp/task_add.jsp";
    }


    @RequestMapping("insert")
    @ResponseBody
    public Result addNewTask(Task task){
        int i = taskServices.insertNewTask(task);
        Result result = new Result();
        if(i>0){
            result.setStatus(200);
            result.setMsg("ok");
        }else {
            result.setStatus(500);
            result.setMsg("error");
        }
        return result;
    }

    @RequestMapping("edit")
    public String editTask(){
        return "/WEB-INF/jsp/task_edit.jsp";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Result updateTask(Task task){
        int i = taskServices.updateTask(task);
        Result result = new Result();
        if(i>0){
            result.setStatus(200);
            result.setMsg("ok");
        }else {
            result.setStatus(500);
            result.setMsg("error");
        }
        return result;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public Result deleteTasks(String[] ids){
        int i = taskServices.deleteTasks(ids);
        Result result = new Result();
        if(i>0){
            result.setStatus(200);
            result.setMsg("ok");
        }else{
            result.setStatus(500);
            result.setMsg("error");
        }
        return result;
    }

    @RequestMapping("search_task_by_taskId")
    @ResponseBody
    public QueryJsonBean<Task> searchTasksByTaskId(String searchValue, int page ,int rows){
        return taskServices.searchTasks(searchValue,"taskId",page,rows);
    }

    @RequestMapping("search_task_by_taskWorkId")
    @ResponseBody
    public QueryJsonBean<Task> searchTasksByWorkId(String searchValue, int page ,int rows){
        return taskServices.searchTasks(searchValue,"workId",page,rows);
    }

    @RequestMapping("search_task_by_taskManufactureSn")
    @ResponseBody
    public QueryJsonBean<Task> searchTasksByManufactureSn(String searchValue, int page ,int rows){
        return taskServices.searchTasks(searchValue,"manufactureSn",page,rows);
    }
}
