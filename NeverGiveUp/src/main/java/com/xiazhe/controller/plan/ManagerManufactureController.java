package com.xiazhe.controller.plan;


import com.xiazhe.bean.Manufacture;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.bean.plan.PlanManufactureBean;
import com.xiazhe.service.plan.ManufactureServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("manufacture")
public class ManagerManufactureController {
    @Autowired
    ManufactureServices manufactureServices;

    @RequestMapping("find")
    public String manufactureFind(){
        return "/WEB-INF/jsp/manufacture_list.jsp";
    }

    @RequestMapping("list")
    @ResponseBody
    public QueryJsonBean<PlanManufactureBean> getManufactureList(int page ,int rows){
        return manufactureServices.queryManufactures(page,rows);

    }

    @RequestMapping("get_data")
    @ResponseBody
    public List<PlanManufactureBean> getManufactureData(){
       return manufactureServices.getManufactureData();
    }

    @RequestMapping("/*_judge")
    @ResponseBody
    public String manufactureJudge(){
        return null;
    }

    @RequestMapping("add")
    public String add(){
        return "/WEB-INF/jsp/manufacture_add.jsp";
    }

    @RequestMapping("insert")
    @ResponseBody
    public Result insertNewManufacture(Manufacture manufacture){
        int i = manufactureServices.insertNewManufacture(manufacture);
        Result result = new Result();
        if(i>0){
            result.setMsg("ok");
            result.setStatus(200);
        }else{
            result.setStatus(500);
            result.setMsg("error");
        }
        return result;
    }

    @RequestMapping("edit")
    public String edit(){
        return "/WEB-INF/jsp/manufacture_edit.jsp";
    }

    @RequestMapping("update_all")
    @ResponseBody
    public Result updateManufacture(Manufacture manufacture){
        int i = manufactureServices.updateManufacture(manufacture);
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
    public Result deleteManufactures(String[] ids){
        int i = manufactureServices.deleteManufactures(ids);
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

    @RequestMapping("search_manufacture_by_manufactureSn")
    @ResponseBody
    public QueryJsonBean<PlanManufactureBean> searchManufactureByManufactureSn(String searchValue,int page, int rows){
        return manufactureServices.searchPlanManufactureBeans(searchValue,"manufactureSn",page,rows);
    }

    @RequestMapping("search_manufacture_by_manufactureOrderId")
    @ResponseBody
    public QueryJsonBean<PlanManufactureBean> searchManufactureByOrderId(String searchValue,int page, int rows){
        return manufactureServices.searchPlanManufactureBeans(searchValue,"OrderId",page,rows);
    }

    @RequestMapping("search_manufacture_by_manufactureTechnologyName")
    @ResponseBody
    public QueryJsonBean<PlanManufactureBean> searchManufactureByTechnologyId(String searchValue,int page, int rows){
        return manufactureServices.searchPlanManufactureBeans(searchValue,"TechnologyId",page,rows);
    }

    @RequestMapping("get/{id}")
    @ResponseBody
    public PlanManufactureBean getPlanManufactureBean(@PathVariable("id")String id){
        return manufactureServices.getPlanManufacture(id);
    }
}
