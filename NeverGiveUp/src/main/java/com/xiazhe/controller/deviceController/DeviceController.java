package com.xiazhe.controller.deviceController;

import com.xiazhe.bean.DeviceCheck;
import com.xiazhe.bean.DeviceList;
import com.xiazhe.bean.DeviceType;
import com.xiazhe.service.deviceService.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    /*显示home主页*/
    @RequestMapping("/home")
    public String home(){
        return "/WEB-INF/jsp/home.jsp";
    }

    /*显示设备台账页面*/
    @RequestMapping("/device/deviceList")
    public String deviceList(HttpSession session){
        List sysPermissionList = new ArrayList<>();
        sysPermissionList.add("deviceController:add");
        sysPermissionList.add("deviceController:edit");
        sysPermissionList.add("deviceController:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "/WEB-INF/jsp/deviceList.jsp";
    }

    /*显示设备台账里的数据内容*/
    @RequestMapping("/deviceList/list")
    @ResponseBody
    public List<DeviceList> displayDeviceListContent(){
        List<DeviceList> deviceLists = deviceService.queryAllDeviceList();
        return deviceLists;
    }

    /*显示设备种类页面*/
    @RequestMapping("/device/deviceType")
    public String deviceType(HttpSession session){
        List sysPermissionList = new ArrayList<>();
        sysPermissionList.add("deviceType:add");
        sysPermissionList.add("deviceType:edit");
        sysPermissionList.add("deviceType:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "/WEB-INF/jsp/deviceType.jsp";
    }

    /*显示设备种类里的数据内容*/
    @RequestMapping("/deviceType/list")
    @ResponseBody
    public DeviceType[] dispalyDeviceTypeContent(){
        DeviceType[] deviceTypes = deviceService.queryAllDeviceType();
        return deviceTypes;
    }

    /*deviceType设备种类新增*/
    @RequestMapping("/deviceType/add_judge")
    @ResponseBody
    public String addDeviceType1(){
        return "{}";
    }

    @RequestMapping("/deviceType/add")
    public String addDeviceType2(){
        return "/WEB-INF/jsp/deviceType_add.jsp";
    }
    @RequestMapping("/deviceType/insert")
    @ResponseBody
    public String addDeviceType(String deviceTypeId,String deviceTypeName,String deviceTypeModel,String deviceTypeSpec,String deviceTypeSupplier,String deviceTypeProducer,Integer deviceTypeQuantity,String deviceTypeWarranty){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date parse = simpleDateFormat.parse(deviceTypeWarranty);
            if (deviceTypeQuantity==null){
                deviceTypeQuantity=0;
            }
            deviceService.addDeviceType(new DeviceType(deviceTypeId,deviceTypeName,deviceTypeModel,deviceTypeSpec,deviceTypeSupplier,deviceTypeProducer,deviceTypeQuantity,parse));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "{\"status\":200,\"msg\":\"OK\",\"data\":null}";
    }


    /*显示设备例检页面*/
    @RequestMapping("/device/deviceCheck")
    public String deviceCheck(HttpSession session){
        List sysPermissionList = new ArrayList<>();
        sysPermissionList.add("deviceCheck:add");
        sysPermissionList.add("deviceCheck:edit");
        sysPermissionList.add("deviceCheck:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);
        return "/WEB-INF/jsp/deviceCheck.jsp";
    }

    /*显示设备台账里的数据内容*/
    @RequestMapping("/deviceCheck/list")
    @ResponseBody
    public void displayDeviceCheckContent(){
        deviceService.queryAllDeviceCheck();
    }
}
