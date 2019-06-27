package com.xiazhe.controller.TechnologyController;

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
}
