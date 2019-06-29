package com.xiazhe.controller.deviceController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/device")
public class DeviceController {

    /*1.显示deviceList设备台账页面*/
    @RequestMapping("/deviceList")
    public String deviceList(){
        return "/WEB-INF/jsp/deviceList.jsp";
    }

    /*2.显示deviceType设备种类页面*/
    @RequestMapping("/deviceType")
    public String deviceType(){
        return "/WEB-INF/jsp/deviceType.jsp";
    }

    /*3.显示deviceCheck设备例检页面*/
    @RequestMapping("/deviceCheck")
    public String deviceCheck(){
        return "/WEB-INF/jsp/deviceCheck.jsp";
    }

    /*4.显示deviceFault设备故障页面*/
    @RequestMapping("/deviceFault")
    public String deviceFault(){
        return "/WEB-INF/jsp/deviceFault.jsp";
    }

    /*5.显示deviceMaintain设备维修页面*/
    @RequestMapping("/deviceMaintain")
    public String deviceMaintain(){
        return "/WEB-INF/jsp/deviceMaintain.jsp";
    }

}
