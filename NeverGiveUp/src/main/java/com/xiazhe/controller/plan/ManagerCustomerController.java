package com.xiazhe.controller.plan;


import com.xiazhe.bean.Custom;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.plan.CustomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("custom")
public class ManagerCustomerController {

    @Autowired
    CustomServices customServices;

    @RequestMapping("find")
    public String customFind(HttpServletRequest request){
        List<String> list = new LinkedList<>();
        list.add("custom:add");
        list.add("custom:edit");
        list.add("custom:delete");
        request.getSession().setAttribute("sysPermissionList",list);
        return "/WEB-INF/jsp/custom_list.jsp";
    }


    @RequestMapping("list")
    @ResponseBody
    public QueryJsonBean<Custom> getCustomList(int page, int rows){
        return customServices.queryCustomPages(page,rows);
    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<Custom> getCustomData(){
        return customServices.getCustomData();
    }

    @RequestMapping("/*_judge")
    @ResponseBody
    public String customjudge(){
        return null;
    }

    @RequestMapping("add")
    public String addCustom(){
        return "/WEB-INF/jsp/custom_add.jsp";
    }

    @RequestMapping(value="/get/{id}")
    @ResponseBody
    public Custom restGetCustom(@PathVariable(value = "id")String id){
        Custom custom = customServices.queryCustomById(id);
        return custom;
    }
}
