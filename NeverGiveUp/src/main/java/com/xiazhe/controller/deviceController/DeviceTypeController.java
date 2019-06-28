package com.xiazhe.controller.deviceController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.DeviceCheck;
import com.xiazhe.bean.DeviceList;
import com.xiazhe.bean.DeviceType;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.deviceService.DeviceService;
import com.xiazhe.vo.ResponseVo;
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

@Controller
public class DeviceController {

    @Autowired
    DeviceService deviceService;
    DeviceDataPackge deviceDataPackge = new DeviceDataPackge();


    /*显示home主页*/
    @RequestMapping("/home")
    public String home(){
        return "/WEB-INF/jsp/home.jsp";
    }

    /**
     *(一)设备台账
     */
    /*1.显示deviceList设备台账页面*/
    @RequestMapping("/device/deviceList")
    public String deviceList(HttpSession session){
        deviceDataPackge.ableSysPermissionList(session,"Controller");
        return "/WEB-INF/jsp/deviceList.jsp";
    }

    /*2.显示deviceList设备台账里的数据内容*/
    @RequestMapping("/deviceList/list")
    @ResponseBody
    public List<DeviceList> displayDeviceListContent(){
        List<DeviceList> deviceLists = deviceService.queryAllDeviceList();
        return deviceLists;
    }

    /**
     * (二)设备种类
     */
    /*1.显示deviceType设备种类页面*/
    @RequestMapping("/device/deviceType")
    public String deviceType(HttpSession session){
        deviceDataPackge.ableSysPermissionList(session,"Type");
        return "/WEB-INF/jsp/deviceType.jsp";
    }

    /*2.显示deviceType设备种类里的数据内容*/
    @RequestMapping("/deviceType/list")
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
    @RequestMapping("/deviceType/add_judge")
    @ResponseBody
    public String addDeviceType1(){
        return "{}";
    }
    @RequestMapping("/deviceType/add")
    public String addDeviceType2(){
        return "/WEB-INF/jsp/deviceType_add.jsp";
    }
    //3.2新增操作
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

    /*4.deviceType设备种类编辑*/
    //4.1跳转至编辑页面
    @RequestMapping("/deviceType/edit_judge")
    @ResponseBody
    public String editDeviceType1(){
        return "{}";
    }
    @RequestMapping("/deviceType/edit")
    public String editDeviceType2(){
        return "/WEB-INF/jsp/deviceType_edit.jsp";
    }
    //4.2编辑操作
    @RequestMapping("/deviceType/update")
    @ResponseBody
    public String editDeviceType(String deviceTypeId,String deviceTypeName,String deviceTypeModel,String deviceTypeSpec,String deviceTypeSupplier,String deviceTypeProducer,Integer deviceTypeQuantity,String deviceTypeWarranty){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date parse = simpleDateFormat.parse(deviceTypeWarranty);
            if (deviceTypeQuantity==null){
                deviceTypeQuantity=0;
            }
            deviceService.updateDeviceType(new DeviceType(deviceTypeId,deviceTypeName,deviceTypeModel,deviceTypeSpec,deviceTypeSupplier,deviceTypeProducer,deviceTypeQuantity,parse));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "{\"status\":200,\"msg\":\"OK\",\"data\":null}";
    }

    /*5.deviceType设备种类删除*/
    //5.1跳转至删除页面
    @RequestMapping("/deviceType/delete_judge")
    @ResponseBody
    public String deleteDeviceType1(){
        return "{}";
    }

    //5.2删除操作
    @RequestMapping("/deviceType/delete_batch")
    @ResponseBody
    public String deleteDeviceTypeByIds(String[] ids){
        deviceService.deleteDeviceTypeByIds(ids);
        return "{\"status\":200,\"msg\":\"OK\",\"data\":null}";
    }

    /*6.deviceType设备种类查询*/
    //6.1通过设备种类编号deviceTypeId模糊查询
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public DeviceType[] selectByDeviceTypeId(String searchValue){
       DeviceType[] deviceTypes = deviceService.selectByDeviceTypeId(searchValue);

       return deviceTypes;
    }
    //6.2通过设备种类名称deviceTypeName模糊查询
    @RequestMapping("deviceType/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public DeviceType[] selectByDeviceTypeName(String searchValue){
        DeviceType[] deviceTypes = deviceService.selectByDeviceTypeName(searchValue);

        return deviceTypes;
    }



    /*显示deviceCheck设备例检页面*/
    @RequestMapping("/device/deviceCheck")
    public String deviceCheck(HttpSession session){
        deviceDataPackge.ableSysPermissionList(session,"Check");
        return "/WEB-INF/jsp/deviceCheck.jsp";
    }

    /*显示deviceCheck设备例检里的数据内容*/
    @RequestMapping("/deviceCheck/list")
    @ResponseBody
    public void displayDeviceCheckContent(){
        deviceService.queryAllDeviceCheck();
    }
}
