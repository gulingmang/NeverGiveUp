package com.xiazhe.controller.plan;


import com.xiazhe.bean.Custom;
import com.xiazhe.bean.Result;
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
    public String customFind(){
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

    @RequestMapping("insert")
    @ResponseBody
    public Result addNewCustom(Custom custom){
        int i = customServices.insertNewCustom(custom);
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

    @RequestMapping(value="/get/{id}")
    @ResponseBody
    public Custom restGetCustom(@PathVariable(value = "id")String id){
        Custom custom = customServices.queryCustomById(id);
        return custom;
    }

    @RequestMapping("edit")
    public String editCustom(){
        return "/WEB-INF/jsp/custom_edit.jsp";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Result updateOrder(Custom custom){
        int i = customServices.updateCustom(custom);
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

    @RequestMapping("delete_batch")
    @ResponseBody
    public Result deleteCustoms(String[] ids){
        int i = customServices.deleteCustoms(ids);
        Result result = new Result();
        if(i > 0){
            result.setStatus(200);
            result.setMsg("ok");
        }else{
            result.setStatus(500);
            result.setMsg("error");
        }
        return result;
    }

    @RequestMapping("search_custom_by_customId")
    @ResponseBody
    public QueryJsonBean<Custom> searchCustomByCustomId(String searchValue, int page, int rows){
        QueryJsonBean<Custom> queryJsonBean = customServices.searchCustoms(searchValue, "customId", page, rows);
        return queryJsonBean;
    }

    @RequestMapping("search_custom_by_customName")
    @ResponseBody
    public QueryJsonBean<Custom> searchCustomByCustomName(String searchValue, int page, int rows){
        QueryJsonBean<Custom> queryJsonBean = customServices.searchCustoms(searchValue, "customName", page, rows);
        return queryJsonBean;
    }
}
