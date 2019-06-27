package com.xiazhe.controller.TechnologyController;

import com.xiazhe.bean.Result;
import com.xiazhe.bean.Technology;
import com.xiazhe.bean.TechnologyRequirement;
import com.xiazhe.service.technologyService.TechnologyRequirementService;
import com.xiazhe.service.technologyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {
    @Autowired
    TechnologyRequirementService technologyRequirementService;
    @Autowired
    TechnologyService technologyService;
    //显示工艺要求管理列表
    @RequestMapping("/find")
    public String toTechnologyRList(HttpSession httpSession){
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("technologyRequirement:add");
        objects.add("technologyRequirement:edit");
        objects.add("technologyRequirement:delete");
        httpSession.setAttribute("sysPermissionList",objects);
        return "/WEB-INF/jsp/technologyRequirement_list.jsp";
    }
    @RequestMapping("/list")
    @ResponseBody
    public List<TechnologyRequirement> queryAllTechnologyR(){
        List<TechnologyRequirement> technologyRequirements = technologyRequirementService.queryAllTechnology();
        return technologyRequirements;
    }

    //rest风格在工艺要求上显示工艺信息
    @RequestMapping(value = "/get/{technologyId}",method = RequestMethod.GET)
    @ResponseBody
    public Technology queryTechnologyById(String technologyId){
        Technology technology = technologyService.queryTechnologyById(technologyId);
        return technology;
    }

    //通过id进行模糊查询
    @RequestMapping("/search_technologyRequirement_by_technologyRequirementId")
    @ResponseBody
    public TechnologyRequirement[] selectByIdAm(String searchValue){
        TechnologyRequirement[] technologyRequirements = technologyRequirementService.selectByPrimaryKey(searchValue);
        return technologyRequirements;
    }

    /*增加工艺*/
    //跳转至增加页面
    @RequestMapping("add_judge")
    public String toAddjudge(){
        return "/WEB-INF/jsp/technologyRequirement_add.jsp";
    }
    @RequestMapping("add")
    public String toAdd(){
        return "/WEB-INF/jsp/technologyRequirement_add.jsp";
    }
    //增加工艺要求操作
    @RequestMapping("insert")
    @ResponseBody
    public Result insert(TechnologyRequirement technologyRequirement){
        technologyRequirementService.insert(technologyRequirement);
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

    //删除工艺要求操作
    //跳转至删除页面
    @RequestMapping("delete_judge")
    public String toDeletejudge(){
        return "/WEB-INF/jsp/technologyRequirement_list.jsp";
    }
    //批量删除操作
    @RequestMapping("delete_batch")
    @ResponseBody
    public Result delete(String[] ids){
        technologyRequirementService.deleteByPrimaryKey(ids);
        Result result = new Result();
        result.setData(null);
        result.setMsg("Ok");
        result.setStatus(200);
        return result;
    }
}
