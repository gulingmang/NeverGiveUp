package com.xiazhe.controller.deviceController;

import com.xiazhe.service.deviceService.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * deviceCheck设备例检
 * 包括显示页面及页面数据内容、新增、编辑、删除、查询、分页操作
 */
@Controller
public class DeviceCheckController {

    @Autowired
    DeviceService deviceService;


    /*显示deviceCheck设备例检里的数据内容*/
    @RequestMapping("/deviceCheck/list")
    @ResponseBody
    public void displayDeviceCheckContent(){
        deviceService.queryAllDeviceCheck();
    }

}
