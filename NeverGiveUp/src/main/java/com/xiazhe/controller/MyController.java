package com.xiazhe.controller;

import com.xiazhe.bean.User;
import com.xiazhe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    @Autowired
    UserService userService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello(String value) {
        int x = Integer.parseInt(value);
        User user = userService.selectByid(x);
        return user.toString();

    }

    @RequestMapping("/erp")
    public String home(HttpServletRequest request) {
        List sysPermissionList = new ArrayList();
        sysPermissionList.add("user:add");
        sysPermissionList.add("user:edit");
        sysPermissionList.add("user:delete");
        sysPermissionList.add("custom:add");
        sysPermissionList.add("custom:edit");
        sysPermissionList.add("custom:delete");
        sysPermissionList.add("department:add");
        sysPermissionList.add("department:edit");
        sysPermissionList.add("department:delete");
        sysPermissionList.add("deviceCheck:add");
        sysPermissionList.add("deviceCheck:edit");
        sysPermissionList.add("deviceCheck:delete");
        sysPermissionList.add("deviceFault:add");
        sysPermissionList.add("deviceFault:edit");
        sysPermissionList.add("deviceFault:delete");
        sysPermissionList.add("device:add");
        sysPermissionList.add("device:edit");
        sysPermissionList.add("device:delete");
        sysPermissionList.add("deviceMaintain:add");
        sysPermissionList.add("deviceMaintain:edit");
        sysPermissionList.add("deviceMaintain:delete");
        sysPermissionList.add("deviceType:add");
        sysPermissionList.add("deviceType:edit");
        sysPermissionList.add("deviceType:delete");
        sysPermissionList.add("employee:add");
        sysPermissionList.add("employee:edit");
        sysPermissionList.add("employee:delete");
        sysPermissionList.add("fCountCheck:add");
        sysPermissionList.add("fCountCheck:edit");
        sysPermissionList.add("fCountCheck:delete");
        sysPermissionList.add("manufacture:add");
        sysPermissionList.add("manufacture:edit");
        sysPermissionList.add("manufacture:delete");
        sysPermissionList.add("material:add");
        sysPermissionList.add("material:edit");
        sysPermissionList.add("material:delete");
        sysPermissionList.add("materialConsume:add");
        sysPermissionList.add("materialConsume:edit");
        sysPermissionList.add("materialConsume:delete");
        sysPermissionList.add("materialReceive:add");
        sysPermissionList.add("materialReceive:edit");
        sysPermissionList.add("materialReceive:delete");
        sysPermissionList.add("fMeasureCheck:add");
        sysPermissionList.add("fMeasureCheck:edit");
        sysPermissionList.add("fMeasureCheck:delete");
        sysPermissionList.add("order:add");
        sysPermissionList.add("order:edit");
        sysPermissionList.add("order:delete");
        sysPermissionList.add("pCountCheck:add");
        sysPermissionList.add("pCountCheck:edit");
        sysPermissionList.add("pCountCheck:delete");
        sysPermissionList.add("pMeasureCheck:add");
        sysPermissionList.add("pMeasureCheck:edit");
        sysPermissionList.add("pMeasureCheck:delete");
        sysPermissionList.add("process:add");
        sysPermissionList.add("process:edit");
        sysPermissionList.add("process:delete");
        sysPermissionList.add("product:add");
        sysPermissionList.add("product:edit");
        sysPermissionList.add("product:delete");
        sysPermissionList.add("task:add");
        sysPermissionList.add("task:edit");
        sysPermissionList.add("task:delete");
        sysPermissionList.add("technology:add");
        sysPermissionList.add("technology:edit");
        sysPermissionList.add("technology:delete");
        sysPermissionList.add("technologyPlan:add");
        sysPermissionList.add("technologyPlan:edit");
        sysPermissionList.add("technologyPlan:delete");
        sysPermissionList.add("technologyRequirement:add");
        sysPermissionList.add("technologyRequirement:edit");
        sysPermissionList.add("technologyRequirement:delete");
        sysPermissionList.add("unqualify:add");
        sysPermissionList.add("unqualify:edit");
        sysPermissionList.add("unqualify:delete");
        sysPermissionList.add("work:add");
        sysPermissionList.add("work:edit");
        sysPermissionList.add("work:delete");
        request.getSession().setAttribute("sysPermissionList",sysPermissionList);
        return "/WEB-INF/jsp/home.jsp";
    }

    /*@RequestMapping(value="hello1",produces= MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")*/
    @RequestMapping("hello1")
    @ResponseBody
    public String hello1(MultipartFile filez) throws IOException {

        String originalFilename = filez.getOriginalFilename();
        System.out.println(originalFilename);
        String path = getClass().getClassLoader().getResource("../../").getPath();
        File f = new File(path, originalFilename);
        if (!f.exists()) f.createNewFile();
        System.out.println(f);
        filez.transferTo(f);
        return "success";
    }
    @RequestMapping("hello3")
    @ResponseBody
    public String hello3(String value) {
        int x = Integer.parseInt(value);
        User user = userService.selectByid(x);
        return user.toString();

    }

}
