package com.xiazhe.controller.fcountcheckController;

import com.xiazhe.bean.FinalCountCheck;
import com.xiazhe.service.finalCountCheckService.FinalCountCheckServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FcountcheckController {
    @Autowired
    FinalCountCheckServiceImpl myservice;

    @RequestMapping("f_count_check/find")

    public String find(HttpSession sessions) {
        List<String> sysPermissionList = new ArrayList<>();

        sysPermissionList.add("fCountCheck:add");
        sysPermissionList.add("fCountCheck:edit");
        sysPermissionList.add("fCountCheck:delete");
        sessions.setAttribute("sysPermissionList", sysPermissionList);
        return "/WEB-INF/jsp/f_count_check_list.jsp";
    }

    @RequestMapping("f_count_check/list")
    @ResponseBody
    public List<FinalCountCheck> getlist() {

        List<FinalCountCheck> getlist = myservice.getlist();
        return getlist;
    }
}
