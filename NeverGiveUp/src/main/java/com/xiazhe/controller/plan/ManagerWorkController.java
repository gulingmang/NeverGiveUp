package com.xiazhe.controller.plan;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("work")
public class ManagerWorkController {


    @RequestMapping("find")
    public String findWork(){
        return "/WEB-INF/jsp/work_list.jsp";
    }
}
