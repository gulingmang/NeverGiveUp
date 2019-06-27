package com.xiazhe.controller.unqualifyManger;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("tohome")
    public String home(){
        System.out.println("来了");
        return  "forward:/WEB-INF/jsp/home.jsp";
    }
}
