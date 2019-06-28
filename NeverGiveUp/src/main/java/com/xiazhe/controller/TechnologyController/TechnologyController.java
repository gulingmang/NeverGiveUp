package com.xiazhe.controller.TechnologyController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.Technology;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.technologyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/technology")
public class TechnologyController {
    @Autowired
    TechnologyService technologyService;
    //显示工艺管理列表
    @RequestMapping("/find")
    public String toTechnologyList(HttpSession httpSession){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("technology:add");
        objects.add("technology:edit");
        objects.add("technology:delete");
        httpSession.setAttribute("sysPermissionList",objects);
        return "/WEB-INF/jsp/technology_list.jsp";
    }
    @RequestMapping("/list")
    @ResponseBody
    public QueryJsonBean<Technology> queryAllTechnology(int page,int rows){
        PageHelper pageHelper = new PageHelper();
        Page<Technology> technologypage = pageHelper.startPage(page, rows);
        List<Technology> technologies = technologyService.queryAllTechnology();
        QueryJsonBean<Technology> technologyQueryJsonBean = new QueryJsonBean<>();
        technologyQueryJsonBean.setRows(technologies);
        technologyQueryJsonBean.setTotal((int) technologypage.getTotal());
        return technologyQueryJsonBean;
    }


    //通过id进行模糊查询
    @RequestMapping("/search_technology_by_technologyId")
    @ResponseBody
    public Technology[] selectByIdAm(String searchValue){
        Technology[] technologies = technologyService.selectByPrimaryKey(searchValue);
        return technologies;
    }
    //通过name进行模糊查询
    @RequestMapping("/search_technology_by_technologyName")
    @ResponseBody
    public Technology[] selectByIdName(String searchValue){
        Technology[] technologies = technologyService.selectByName(searchValue);
        return technologies;
    }
    //
    /*增加工艺*/
    //跳转至增加页面
    @RequestMapping("add_judge")
    public String toAddjudge(){
        return "/WEB-INF/jsp/technology_add.jsp";
    }
    @RequestMapping("add")
    public String toAdd(){
        return "/WEB-INF/jsp/technology_add.jsp";
    }
    //增加工艺操作
    @RequestMapping("insert")
    @ResponseBody
    public Result insert(Technology technology){
        technologyService.insert(technology);
        Result result = new Result();
        result.setData(null);
        result.setMsg("Ok");
        result.setStatus(200);
        return result;
    }

    /*工艺修改*/
    //跳转至修改界面
    @RequestMapping("edit_judge")
    public String toEditjudge(){
        return "/WEB-INF/jsp/technology_edit.jsp";
    }
    @RequestMapping("edit")
    public String toEdit(){
        return "/WEB-INF/jsp/technology_edit.jsp";
    }

    //修改工艺操作
    @RequestMapping("update_all")
    @ResponseBody
    public Result edit(Technology technology){
        technologyService.updateByPrimaryKey(technology);
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
        return "/WEB-INF/jsp/technology_list.jsp";
    }
    //批量删除操作
    @RequestMapping("delete_batch")
    @ResponseBody
    public Result delete(String[] ids){//参数名称要与前端传来的一样，mapper层注解也是
        technologyService.deleteByPrimaryKey(ids);
        Result result = new Result();
        result.setData(null);
        result.setMsg("Ok");
        result.setStatus(200);
        return result;
    }

    //获取工艺名称操作
    @RequestMapping("get_data")
    @ResponseBody
    public List<Technology> queryAllTechnology(){
        List<Technology> technologies = technologyService.queryAllTechnology();
        return technologies;
    }

    //rest风格在工艺要求上显示工艺信息
    @RequestMapping(value = "/get/{technologyId}",method = RequestMethod.GET)
    @ResponseBody
    public Technology queryTechnologyById(@PathVariable String technologyId){
        Technology technology = technologyService.queryTechnologyById(technologyId);
        return technology;
    }

}
