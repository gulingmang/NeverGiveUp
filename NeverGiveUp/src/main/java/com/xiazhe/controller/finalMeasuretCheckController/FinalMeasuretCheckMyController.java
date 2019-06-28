package com.xiazhe.controller.finalMeasuretCheckController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FinalMeasuretCheckMyController {
    @RequestMapping("measure/find")
    @ResponseBody
    public String getlisturl(){
        return  "/WEB-INF/jsp/measurement_list.jsp";
    }
}
