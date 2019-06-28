package com.xiazhe.controller.finalMeasuretCheckController;

import com.xiazhe.bean.FinalMeasuretCheck;
import com.xiazhe.service.finalMeasureCheckService.FinalMeasuretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class FinalMeasuretCheckMyController {
    @Autowired
    FinalMeasuretService myservice;
    @RequestMapping("measure/find")
    @ResponseBody
    public String getlisturl(){
        return  "/WEB-INF/jsp/measurement_list.jsp";
    }
    @RequestMapping("measure/list")
    @ResponseBody
    public List<FinalMeasuretCheck> returnalist(int page, int rows){
        List<FinalMeasuretCheck> getlist = myservice.getlist();
        return getlist;
    }
}
