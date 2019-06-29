package com.xiazhe.controller.deviceController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.DeviceList;
import com.xiazhe.bean.DeviceList;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.deviceService.DeviceListService;
import com.xiazhe.service.deviceService.DeviceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
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
    DeviceListService deviceListService;

    /*deviceList显示页面数据内容*/
    @RequestMapping("/list")
    @ResponseBody
    public QueryJsonBean dispalyDeviceListContent(int page,int rows){
        PageHelper pageHelper = new PageHelper();
        Page<DeviceList> resultPage = pageHelper.startPage(page, rows);
        List<DeviceList> deviceLists = deviceListService.queryAllDeviceList();
        QueryJsonBean<DeviceList> deviceListQueryJsonBean = new QueryJsonBean<>();
        deviceListQueryJsonBean.setRows(deviceLists);
        deviceListQueryJsonBean.setTotal((int)resultPage.getTotal());
        return deviceListQueryJsonBean;
    }

    /*新增*/
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addDeviceList1(){
        return "{}";
    }
    @RequestMapping("/add")
    public String addDeviceList2(){
        return "/WEB-INF/jsp/deviceList_add.jsp";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Result addDeviceList(String deviceId, String deviceName, String deviceListId, String deviceStatusId, Date devicePurchaseDate, BigDecimal devicePurchasePrice, Date deviceManufactureDate, Date deviceServiceLife, String deviceKeeperId, String note){
        deviceListService.addDeviceList(new DeviceList(deviceId,deviceName,deviceListId,deviceStatusId,devicePurchaseDate,devicePurchasePrice,deviceManufactureDate,deviceServiceLife,deviceKeeperId,note));
        return new Result(200,"OK",null);
    }

    /*编辑*/
    /*4.deviceList设备种类编辑*/
    //4.1跳转至编辑页面
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editDeviceList1(){
        return "{}";
    }
    @RequestMapping("/edit")
    public String editDeviceList2(){
        return "/WEB-INF/jsp/deviceList_edit.jsp";
    }
    //4.2编辑操作
    @RequestMapping("/update")
    @ResponseBody
    public Result editDeviceList(String deviceId, String deviceName, String deviceListId, String deviceStatusId, Date devicePurchaseDate, BigDecimal devicePurchasePrice, Date deviceManufactureDate, Date deviceServiceLife, String deviceKeeperId, String note){
        deviceListService.editDeviceList(new DeviceList(deviceId,deviceName,deviceListId,deviceStatusId,devicePurchaseDate,devicePurchasePrice,deviceManufactureDate,deviceServiceLife,deviceKeeperId,note));
        return new Result(200,"OK",null);
    }

    /*5.deviceList设备种类删除*/
    //5.1跳转至删除页面
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteDeviceList1(){
        return "{}";
    }

    //5.2删除操作
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Result deleteDeviceListByIds(String[] ids){
        deviceListService.deleteDeviceListByIds(ids);
        return new Result(200,"OK",null);
    }

    /*6.deviceList设备种类查询*/
    //6.1通过设备种类编号deviceListId模糊查询
    @RequestMapping("/search_device_by_deviceId")
    @ResponseBody
    public QueryJsonBean selectByDeviceListId(String searchValue,int page,int rows){
        PageHelper pageHelper = new PageHelper();
        Page<DeviceList> resultPage = pageHelper.startPage(page, rows);
        List<DeviceList> deviceLists = deviceListService.selectByDeviceListId(searchValue);
        QueryJsonBean<DeviceList> deviceListQueryJsonBean = new QueryJsonBean<>();
        deviceListQueryJsonBean.setRows(deviceLists);
        deviceListQueryJsonBean.setTotal((int)resultPage.getTotal());
        return deviceListQueryJsonBean;
    }
    //6.2通过设备种类名称deviceListName模糊查询
    @RequestMapping("/search_device_by_deviceName")
    @ResponseBody
    public QueryJsonBean selectByDeviceListName(String searchValue,int page,int rows){
        PageHelper pageHelper = new PageHelper();
        Page<DeviceList> resultPage = pageHelper.startPage(page, rows);
        List<DeviceList> deviceLists = deviceListService.selectByDeviceListName(searchValue);
        QueryJsonBean<DeviceList> deviceListQueryJsonBean = new QueryJsonBean<>();
        deviceListQueryJsonBean.setRows(deviceLists);
        deviceListQueryJsonBean.setTotal((int)resultPage.getTotal());
        return deviceListQueryJsonBean;
    }

   /* @RequestMapping("/search_device_by_deviceTypeName")
    @ResponseBody
    public QueryJsonBean selectByDeviceListSpecName(String searchValue,int page,int rows){
        PageHelper pageHelper = new PageHelper();
        Page<DeviceList> resultPage = pageHelper.startPage(page, rows);
        List<DeviceList> deviceLists = deviceListService.selectByDeviceListSpecName(searchValue);
        QueryJsonBean<DeviceList> deviceListQueryJsonBean = new QueryJsonBean<>();
        deviceListQueryJsonBean.setRows(deviceLists);
        deviceListQueryJsonBean.setTotal((int)resultPage.getTotal());
        return deviceListQueryJsonBean;
    }*/
    
    //get_data获取数据
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceList> deviceListGetDate(){
        return deviceListService.queryAllDeviceList();
    }


}
