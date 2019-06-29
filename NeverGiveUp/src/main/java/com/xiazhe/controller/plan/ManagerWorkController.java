package com.xiazhe.controller.plan;


import com.xiazhe.bean.Result;
import com.xiazhe.bean.Work;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.bean.plan.PlanWorkBean;
import com.xiazhe.service.plan.WorkServices;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.sqlprovider.ProviderApplyWhereMethodGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller()
@RequestMapping("work")
public class ManagerWorkController {

    @Autowired
    WorkServices workServices;

    @RequestMapping("find")
    public String findWork() {
        return "/WEB-INF/jsp/work_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryJsonBean<PlanWorkBean> getWorkList(int page, int rows) {
        QueryJsonBean<PlanWorkBean> queryJsonBean = workServices.queryWorkPages(page, rows);
        return queryJsonBean;
    }

    @RequestMapping("/*_judge")
    @ResponseBody
    public String workJudge() {
        return null;
    }

    @RequestMapping("add")
    public String work() {
        return "/WEB-INF/jsp/work_add.jsp";
    }

    @RequestMapping("insert")
    @ResponseBody
    public Result addNewWork(Work work) {
        int i = workServices.insertNewWork(work);
        Result result = new Result();
        if (i > 0) {
            result.setStatus(200);
            result.setMsg("ok");
        } else {
            result.setStatus(500);
            result.setMsg("error");
        }
        return result;
    }

    @RequestMapping("edit")
    public String edit() {
        return "/WEB-INF/jsp/work_edit.jsp";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Result updateWork(Work work) {
        int i = workServices.updateWork(work);
        Result result = new Result();
        if (i > 0) {
            result.setStatus(200);
            result.setMsg("ok");
        } else {
            result.setStatus(500);
            result.setMsg("error");
        }
        return result;
    }

    @RequestMapping("delete_batch")
    @ResponseBody
    public Result deleteWorks(String[] ids) {
        int i = workServices.deleteWorks(ids);
        Result result = new Result();
        if (i > 0) {
            result.setStatus(200);
            result.setMsg("ok");
        } else {
            result.setStatus(500);
            result.setMsg("error");
        }
        return result;
    }

    @RequestMapping("search_work_by_workId")
    @ResponseBody
    public QueryJsonBean<Work> searchWorksByWorkId(String searchValue, int page, int rows) {
        return workServices.searchWorks(searchValue, "workId", page, rows);
    }


    @RequestMapping("search_work_by_workProduct")
    @ResponseBody
    public QueryJsonBean<Work> searchWorksByProductId(String searchValue, int page, int rows) {
        return workServices.searchWorks(searchValue, "productId", page, rows);
    }

    @RequestMapping("search_work_by_workDevice")
    @ResponseBody
    public QueryJsonBean<Work> searchWorksByDeviceId(String searchValue, int page, int rows) {
        return workServices.searchWorks(searchValue, "deviceId", page, rows);
    }

    @RequestMapping("search_work_by_workProcess")
    @ResponseBody
    public QueryJsonBean<Work> searchWorksByProcessId(String searchValue, int page, int rows) {
        return workServices.searchWorks(searchValue, "processId", page, rows);
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<Work> getWorkData() {
        return workServices.getWorkData();
    }

    @RequestMapping("get/{id}")
    @ResponseBody
    public PlanWorkBean getWork(@PathVariable("id")String id){
        PlanWorkBean planWorkBean = workServices.getWorkById(id);
        return planWorkBean;
    }



}
