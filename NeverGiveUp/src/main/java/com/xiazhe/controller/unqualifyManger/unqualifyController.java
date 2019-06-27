
package com.xiazhe.controller.unqualifyManger;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.UnQualifyApply;

import com.xiazhe.service.unqulifyControllerService.UnqualifyService;
import com.xiazhe.service.unqulifyControllerService.UnqualifyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class unqualifyController {
    @Autowired
    UnqualifyService myapplyservice;

    @RequestMapping("unqualify/find")

    public String tiaozhuan(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<String> s = new ArrayList<>();
        s.add("unqualify:add");
        s.add("unqualify:edit");
        s.add("unqualify:delete");
        session.setAttribute("sysPermissionList", s);
        return "/WEB-INF/jsp/unqualify_list.jsp";
    }

    @RequestMapping("unqualify/list")
    @ResponseBody
    public List<UnQualifyApply> unqualify(int page, int rows) {
        PageHelper helper = new PageHelper();
        helper.offsetPage((page - 1) * rows, rows);
        List<UnQualifyApply> applyList = myapplyservice.getApplyList();
        return applyList;

    }

    @RequestMapping("unqualify/add_judge")
    @ResponseBody
    public String toadd() {
       return "";

    }
    @RequestMapping("unqualify/add")
    public String addagain() {
        return "/WEB-INF/jsp/unqualify_add.jsp";
    }
}

