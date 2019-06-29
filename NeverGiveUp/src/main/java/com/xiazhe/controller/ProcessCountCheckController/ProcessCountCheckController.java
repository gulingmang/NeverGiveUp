package com.xiazhe.controller.ProcessCountCheckController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.ProcessCountCheck;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.Technology;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.processCountCheckService.ProcessCountCheckService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ZhengX
 * @create 2019-06-29 18:00
 **/
@Controller

public class ProcessCountCheckController {
    @Autowired
    ProcessCountCheckService processCountCheckService;
    //显示工序计数质检列表
    @RequestMapping("p_count_check/find")
    public String toCountcheck(){
        return "/WEB-INF/jsp/p_count_check_list.jsp";
    }
    @RequestMapping("p_count_check/list")
    @ResponseBody
    public QueryJsonBean<ProcessCountCheck> queryAllTechnology(int page, int rows){
        PageHelper pageHelper = new PageHelper();
        Page<ProcessCountCheck> technologypage = pageHelper.startPage(page, rows);
        List<ProcessCountCheck> processCountChecks = processCountCheckService.queryAll();
        QueryJsonBean<ProcessCountCheck> technologyQueryJsonBean = new QueryJsonBean<>();
        technologyQueryJsonBean.setRows(processCountChecks);
        technologyQueryJsonBean.setTotal((int) technologypage.getTotal());
        return technologyQueryJsonBean;
    }

    //增加一条信息
    @RequestMapping("pCountCheck/add_judge")
    public String toAddJudge(){
        return "/WEB-INF/jsp/p_count_check_add.jsp";
    }
    @RequestMapping("p_count_check/add")
    public String toAdd(){
        return "/WEB-INF/jsp/p_count_check_add.jsp";
    }
    @RequestMapping("p_count_check/insert")
    @ResponseBody
    public Result addCountCheck(ProcessCountCheck processCountCheck){
        processCountCheckService.insert(processCountCheck);
        Result result = new Result();
        result.setData(null);
        result.setMsg("OK");
        result.setStatus(200);
        return result;
    }

    //编辑一条信息
    @RequestMapping("pCountCheck/edit_judge")
    public String toEditJudge(){
        return "/WEB-INF/jsp/p_count_check_edit.jsp";
    }
    @RequestMapping("p_count_check/edit")
    public String toEdit(){
        return "/WEB-INF/jsp/p_count_check_edit.jsp";
    }
    @RequestMapping("p_count_check/update_all")
    @ResponseBody
    public Result updateCountCheck(ProcessCountCheck processCountCheck){
        processCountCheckService.updateByPrimaryKey(processCountCheck);
        Result result = new Result();
        result.setData(null);
        result.setMsg("OK");
        result.setStatus(200);
        return result;
    }

    //批量删除工序计数质检
    @RequestMapping("pCountCheck/delete_judge")
    public String todeleteJudge(){
        return "/WEB-INF/jsp/p_count_check_edit.jsp";
    }
    @RequestMapping("p_count_check/delete_batch")
    @ResponseBody
    public Result deleteCountCheck(String[] ids){
        processCountCheckService.deleteByPrimaryKey(ids);
        Result result = new Result();
        result.setData(null);
        result.setMsg("OK");
        result.setStatus(200);
        return result;
    }

    //通过工序质检编号模糊查询
    @RequestMapping("p_count_check/search_pCountCheck_by_pCountCheckId")
    @ResponseBody
    public List<ProcessCountCheck> selectById(String searchValue){
        List<ProcessCountCheck> processCountChecks = processCountCheckService.selectByPrimaryKey(searchValue);
        return processCountChecks;
    }

}
