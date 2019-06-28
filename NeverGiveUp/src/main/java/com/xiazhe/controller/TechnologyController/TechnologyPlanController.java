package com.xiazhe.controller.TechnologyController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.Process;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.Technology;
import com.xiazhe.bean.TechnologyPlan;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.technologyService.TechnologyPlanService;
import com.xiazhe.service.technologyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("technologyPlan")
public class TechnologyPlanController {
    @Autowired
    TechnologyPlanService technologyPlanService;
    @Autowired
    TechnologyService technologyService;
    //显示计划列表
    @RequestMapping("find")
    public String toPlanList(HttpSession httpSession){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("technologyPlan:add");
        objects.add("technologyPlan:edit");
        objects.add("technologyPlan:delete");
        httpSession.setAttribute("sysPermissionList",objects);
        return "/WEB-INF/jsp/technologyPlan_list.jsp";
    }
    @RequestMapping("list")
    @ResponseBody
    public QueryJsonBean<TechnologyPlan> queryAllTechnology(int page, int rows){
        PageHelper pageHelper = new PageHelper();
        Page<TechnologyPlan> technologyPlanPage = pageHelper.startPage(page, rows);
        List<TechnologyPlan> technologyPlans = technologyPlanService.queryAllTechnology();
        QueryJsonBean<TechnologyPlan> processQueryJsonBean = new QueryJsonBean<>();
        processQueryJsonBean.setRows(technologyPlans);
        processQueryJsonBean.setTotal((int) technologyPlanPage.getTotal());
        return processQueryJsonBean;
    }
    //rest风格在工序管理上显示工艺计划
    @RequestMapping(value = "/get/{technologyId}",method = RequestMethod.GET)
    @ResponseBody
    public TechnologyPlan queryTechnologyById(@PathVariable String technologyId){
        TechnologyPlan technologyPlan = technologyPlanService.queryPlanById(technologyId);
        return technologyPlan;
    }



    //通过id进行工艺计划模糊查询
    @RequestMapping("/search_technologyPlan_by_technologyPlanId")
    @ResponseBody
    public TechnologyPlan[] selectByIdAm(String searchValue){
        TechnologyPlan[] technologyPlans = technologyPlanService.selectByPrimaryKey(searchValue);
        return technologyPlans;
    }
    //通过name进行工艺计划模糊查询
    @RequestMapping("/search_technologyPlan_by_technologyName")
    @ResponseBody
    public TechnologyPlan[] selectByName(String searchValue){
        TechnologyPlan[] technologyPlans = technologyPlanService.selectByName(searchValue);
        return technologyPlans;
    }
    //
    /*增加工艺*/
    //跳转至增加页面
    @RequestMapping("add_judge")
    public String toAddjudge(){
        return "/WEB-INF/jsp/technologyPlan_add.jsp";
    }
    @RequestMapping("add")
    public String toAdd(){
        return "/WEB-INF/jsp/technologyPlan_add.jsp";
    }
    //增加工艺操作
    @RequestMapping("insert")
    @ResponseBody
    public Result insert(TechnologyPlan technologyPlan){
        technologyPlanService.insert(technologyPlan);
        Result result = new Result();
        result.setData(null);
        result.setMsg("Ok");
        result.setStatus(200);
        return result;
    }

    /*工艺计划修改*/
    //跳转至修改界面
    @RequestMapping("edit_judge")
    public String toEditjudge(){
        return "/WEB-INF/jsp/technologyPlan_edit.jsp";
    }
    @RequestMapping("edit")
    public String toEdit(){
        return "/WEB-INF/jsp/technologyPlan_edit.jsp";
    }

    //修改工艺操作
    @RequestMapping("update_all")
    @ResponseBody
    public Result edit(TechnologyPlan technologyPlan){
        technologyPlanService.updateByPrimaryKey(technologyPlan);
        Result result = new Result();
        result.setData(null);
        result.setMsg("Ok");
        result.setStatus(200);
        return result;
    }

    /*工艺删除操作*/
    //跳转至删除页面
    @RequestMapping("delete_judge")
    public String todeletejudge(){
        return "/WEB-INF/jsp/technologyPlan_list.jsp";
    }
    //批量删除操作
    @RequestMapping("delete_batch")
    @ResponseBody
    public Result delete(String[] ids){//参数名称要与前端传来的一样，mapper层注解也是
        technologyPlanService.deleteByPrimaryKey(ids);
        Result result = new Result();
        result.setData(null);
        result.setMsg("Ok");
        result.setStatus(200);
        return result;
    }

    //获取工艺名称操作
    @RequestMapping("get_data")
    @ResponseBody
    public List<TechnologyPlan> queryAllTechnology(){
        List<TechnologyPlan> technologies = technologyPlanService.queryAllTechnology();
        return technologies;
    }
}
