package com.xiazhe.controller.deviceController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.DeviceList;
import com.xiazhe.bean.DeviceType;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.deviceService.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * deviceList设备台账
 * 包括显示页面及页面数据内容、新增、编辑、删除、查询、分页操作
 */
@Controller
@RequestMapping("/deviceList")
public class DeviceListController {

    @Autowired
    DeviceService deviceService;

    /*deviceList显示页面数据内容*/
    @RequestMapping("/list")
    @ResponseBody
    public QueryJsonBean dispalyDeviceListContent(int page,int rows){
        PageHelper pageHelper = new PageHelper();
        Page<DeviceList> resultPage = pageHelper.startPage(page, rows);
        List<DeviceList> deviceLists = deviceService.queryAllDeviceList();
        QueryJsonBean<DeviceList> deviceTypeQueryJsonBean = new QueryJsonBean<>();
        deviceTypeQueryJsonBean.setRows(deviceLists);
        deviceTypeQueryJsonBean.setTotal((int)resultPage.getTotal());
        return deviceTypeQueryJsonBean;
    }

    /*新增*/
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addDeviceType1(){
        return "{}";
    }
    @RequestMapping("/add")
    public String addDeviceType2(){
        return "/WEB-INF/jsp/deviceList_add.jsp";
    }
    /*@RequestMapping("/insert")
    @ResponseBody
    public Result addDeviceList(String deviceId, String deviceName, String deviceTypeId, Date devicePurchaseDate, BigDecimal devicePurchasePrice, Date deviceManufactureDate, Date deviceServiceLife, String deviceKeeperId, String note){
        deviceService.addDeviceList(new DeviceList(deviceId,deviceName,deviceTypeId,devicePurchaseDate,devicePurchasePrice,deviceManufactureDate,deviceServiceLife,deviceKeeperId,note));
        return new Result(200,"OK",null);
    }*/



    //get_data获取数据
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceList> deviceListGetDate(){
        return deviceService.queryAllDeviceList();
    }


}
