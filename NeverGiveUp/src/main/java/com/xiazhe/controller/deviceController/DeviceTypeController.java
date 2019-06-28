package com.xiazhe.controller.deviceController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.DeviceCheck;
import com.xiazhe.bean.DeviceList;
import com.xiazhe.bean.DeviceType;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.json.QueryJsonBean;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * deviceType设备种类
 * 包括显示页面及页面数据内容、新增、编辑、删除、查询、分页操作
 */
@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {

    @Autowired
    DeviceService deviceService;


    /*2.显示deviceType设备种类里的数据内容*/
    @RequestMapping("/list")
    @ResponseBody
    public QueryJsonBean dispalyDeviceTypeContent(int page,int rows){
        PageHelper pageHelper = new PageHelper();
        Page<DeviceType> resultPage = pageHelper.startPage(page, rows);
        List<DeviceType> deviceTypes = Arrays.asList(deviceService.queryAllDeviceType());
        QueryJsonBean<DeviceType> deviceTypeQueryJsonBean = new QueryJsonBean<>();
        deviceTypeQueryJsonBean.setRows(deviceTypes);
        deviceTypeQueryJsonBean.setTotal((int)resultPage.getTotal());
        return deviceTypeQueryJsonBean;
    }

    /*3.deviceType设备种类新增*/
    //3.1跳转至新增页面
    @RequestMapping("/add_judge")
    @ResponseBody
    public String addDeviceType1(){
        return "{}";
    }
    @RequestMapping("/add")
    public String addDeviceType2(){
        return "/WEB-INF/jsp/deviceType_add.jsp";
    }
    //3.2新增操作
    @RequestMapping("/insert")
    @ResponseBody
    public Result addDeviceType(String deviceTypeId,String deviceTypeName,String deviceTypeModel,String deviceTypeSpec,String deviceTypeSupplier,String deviceTypeProducer,Integer deviceTypeQuantity,String deviceTypeWarranty){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date parse=null;
            if(deviceTypeWarranty != null && !"".equals(deviceTypeWarranty)) {
                parse = simpleDateFormat.parse(deviceTypeWarranty);
            }
            if (deviceTypeQuantity==null){
                deviceTypeQuantity=0;
            }
            deviceService.addDeviceType(new DeviceType(deviceTypeId,deviceTypeName,deviceTypeModel,deviceTypeSpec,deviceTypeSupplier,deviceTypeProducer,deviceTypeQuantity,parse));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Result(200,"OK",null);
    }

    /*4.deviceType设备种类编辑*/
    //4.1跳转至编辑页面
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editDeviceType1(){
        return "{}";
    }
    @RequestMapping("/edit")
    public String editDeviceType2(){
        return "/WEB-INF/jsp/deviceType_edit.jsp";
    }
    //4.2编辑操作
    @RequestMapping("/update")
    @ResponseBody
    public Result editDeviceType(String deviceTypeId,String deviceTypeName,String deviceTypeModel,String deviceTypeSpec,String deviceTypeSupplier,String deviceTypeProducer,Integer deviceTypeQuantity,String deviceTypeWarranty){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(deviceTypeWarranty);
            if (deviceTypeQuantity==null){
                deviceTypeQuantity=0;
            }
            deviceService.updateDeviceType(new DeviceType(deviceTypeId,deviceTypeName,deviceTypeModel,deviceTypeSpec,deviceTypeSupplier,deviceTypeProducer,deviceTypeQuantity,parse));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Result(200,"OK",null);
    }

    /*5.deviceType设备种类删除*/
    //5.1跳转至删除页面
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteDeviceType1(){
        return "{}";
    }

    //5.2删除操作
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Result deleteDeviceTypeByIds(String[] ids){
        deviceService.deleteDeviceTypeByIds(ids);
        return new Result(200,"OK",null);
    }

    /*6.deviceType设备种类查询*/
    //6.1通过设备种类编号deviceTypeId模糊查询
    @RequestMapping("/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public QueryJsonBean selectByDeviceTypeId(String searchValue,int page,int rows){
        PageHelper pageHelper = new PageHelper();
        Page<DeviceType> resultPage = pageHelper.startPage(page, rows);
        List<DeviceType> deviceTypes = Arrays.asList(deviceService.selectByDeviceTypeId(searchValue));
        QueryJsonBean<DeviceType> deviceTypeQueryJsonBean = new QueryJsonBean<>();
        deviceTypeQueryJsonBean.setRows(deviceTypes);
        deviceTypeQueryJsonBean.setTotal((int)resultPage.getTotal());
        return deviceTypeQueryJsonBean;
    }
    //6.2通过设备种类名称deviceTypeName模糊查询
    @RequestMapping("/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public QueryJsonBean selectByDeviceTypeName(String searchValue,int page,int rows){
        PageHelper pageHelper = new PageHelper();
        Page<DeviceType> resultPage = pageHelper.startPage(page, rows);
        List<DeviceType> deviceTypes = Arrays.asList(deviceService.selectByDeviceTypeName(searchValue));
        QueryJsonBean<DeviceType> deviceTypeQueryJsonBean = new QueryJsonBean<>();
        deviceTypeQueryJsonBean.setRows(deviceTypes);
        deviceTypeQueryJsonBean.setTotal((int)resultPage.getTotal());
        return deviceTypeQueryJsonBean;
    }
}
