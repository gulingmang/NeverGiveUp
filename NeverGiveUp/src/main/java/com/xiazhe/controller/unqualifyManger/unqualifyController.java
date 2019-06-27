
package com.xiazhe.controller.unqualifyManger;

import com.xiazhe.bean.UnQualifyApply;

import com.xiazhe.service.unqulifyControllerService.UnqualifyService;
import com.xiazhe.service.unqulifyControllerService.UnqualifyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class unqualifyController {
    @Autowired
    UnqualifyService myapplyservice;
    @RequestMapping("unqualify/find")

    public String tiaozhuan() {
        return "/WEB-INF/jsp/unqualify_list.jsp";
    }

    @RequestMapping("unqualify/list")
    @ResponseBody
    public List<UnQualifyApply> unqualify() {
        List<UnQualifyApply> applyList = myapplyservice.getApplyList();
        System.out.println(applyList);
        return applyList;

    }

}

