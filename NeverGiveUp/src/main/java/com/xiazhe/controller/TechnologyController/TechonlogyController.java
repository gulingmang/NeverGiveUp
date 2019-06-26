package com.xiazhe.controller.TechnologyController;

import com.xiazhe.bean.Technology.Technology;
import com.xiazhe.service.TechnologyService.TechonlogyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("technology")
public class TechonlogyController {

    @Autowired
    TechonlogyServiceImpl techonlogyService;

    //显示工艺管理列表
    @RequestMapping("/find")
    public String totechnology_list(){
        return "/WEB-INF/jsp/technology_list.jsp";
    }
    @RequestMapping("/list")
    @ResponseBody
    public List<Technology> technology_list(){
        List<Technology> technologies = techonlogyService.queryTechnologyList();
        return technologies;
    }

}
