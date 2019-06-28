package com.xiazhe.controller.deviceController;

import com.xiazhe.service.deviceService.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * deviceList设备台账
 * 包括显示页面及页面数据内容、新增、编辑、删除、查询、分页操作
 */
@Controller
public class DeviceListController {

    @Autowired
    DeviceService deviceService;
    DeviceDataPackge deviceDataPackge = new DeviceDataPackge();

    /*1.显示deviceList设备台账页面*/
    @RequestMapping("/device/deviceList")
    public String deviceList(HttpSession session){
        deviceDataPackge.ableSysPermissionList(session,"Controller");
        return "/WEB-INF/jsp/deviceList.jsp";
    }
}
