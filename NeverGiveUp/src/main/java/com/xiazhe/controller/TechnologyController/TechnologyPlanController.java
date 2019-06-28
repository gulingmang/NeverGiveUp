package com.xiazhe.controller.TechnologyController;

import com.xiazhe.bean.TechnologyPlan;
import com.xiazhe.service.technologyService.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("technologyPlan")
public class TechnologyPlanController {
    @Autowired
    TechnologyPlanService technologyPlanService;
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
    public ArrayList<TechnologyPlan> queryAllPlan(){
        ArrayList<TechnologyPlan> technologyPlans = technologyPlanService.queryAllTechnology();
        return technologyPlans;
    }
}
