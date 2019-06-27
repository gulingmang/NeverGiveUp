package com.xiazhe.controller;

import com.xiazhe.bean.DeviceType;
import com.xiazhe.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DeviceController {

    @Autowired
    DeviceService deviceService;


    @RequestMapping("/home")
    public String home(){
        return "/WEB-INF/jsp/home.jsp";
    }



    @RequestMapping("/device/deviceType")
    public String deviceType(HttpSession session){
        List sysPermissionList = new ArrayList<>();
        sysPermissionList.add("deviceType:add");
        sysPermissionList.add("deviceType:edit");
        sysPermissionList.add("deviceType:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "/WEB-INF/jsp/deviceType.jsp";
    }



    @RequestMapping("/deviceType/list")
    @ResponseBody
    public List dispalyDeviceTypeContent(){
        List list = deviceService.queryAllDeviceType();
        return list;
    }
}
