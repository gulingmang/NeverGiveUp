package com.xiazhe.controller.deviceController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.*;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.deviceService.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/deviceFault")
public class DeviceFaultController {
    @Autowired
    DeviceFaultService deviceFaultService;

    /*操作判断*/
    @RequestMapping("/*_judge")
    @ResponseBody
    public String judge(){
        return "{}";
    }

    /*所有故障列表数据*/
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceFault> allDeviceFaultListData(){
        return deviceFaultService.queryAllDeviceFaults();
    }

    /*故障列表数据*/
    @RequestMapping("/list")
    @ResponseBody
    public QueryJsonBean pageDeviceFaultListData(Integer page, Integer rows){
        PageHelper pageHelper=new PageHelper();
        Page<DeviceFault> resultPage = pageHelper.startPage(page, rows);
        List<DeviceFault> deviceFaultList = deviceFaultService.queryAllDeviceFaults();
        QueryJsonBean<DeviceFault> departmentQueryJsonBean = new QueryJsonBean<>();
        departmentQueryJsonBean.setTotal((int)resultPage.getTotal());
        departmentQueryJsonBean.setRows(deviceFaultList);
        return departmentQueryJsonBean;
    }

    /*故障添加页面*/
    @RequestMapping("/add")
    public String showAddDeviceFaultPage(){
        return "/WEB-INF/jsp/deviceFault_add.jsp";
    }

    /*故障编辑页面*/
    @RequestMapping("/edit")
    public String showEditDeviceFaultPage(){
        return "/WEB-INF/jsp/deviceFault_edit.jsp";
    }

    /*根据数据生成新的DeviceFault bean*/
    private DeviceFault getDeviceFaultBean(String deviceFaultId,String deviceId,String deviceFaultDate,String deviceFaultCause,String deviceFaultMaintenance,String deviceFaultDetail){
        DeviceFault deviceFault = new DeviceFault();
        deviceFault.setDeviceFaultId(deviceFaultId);
        deviceFault.setDeviceId(deviceId);
        try{
            if (deviceFault!=null&&!"".equals(deviceFault)){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                deviceFault.setDeviceFaultDate(simpleDateFormat.parse(deviceFaultDate));
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        deviceFault.setDeviceFaultCause(deviceFaultCause);
        deviceFault.setDeviceFaultMaintenance(deviceFaultMaintenance);
        deviceFault.setDeviceFaultDetail(deviceFaultDetail);
        return deviceFault;
    }

    /*插入故障条目*/
    @RequestMapping("/insert")
    @ResponseBody
    public Result addDeviceFault(String deviceFaultId,String deviceId,String deviceFaultDate,String deviceFaultCause,String deviceFaultMaintenance,String deviceFaultDetail){
        DeviceFault deviceFaultBean = getDeviceFaultBean(deviceFaultId,deviceId,deviceFaultDate,deviceFaultCause,deviceFaultMaintenance,deviceFaultDetail);
        deviceFaultService.addDeviceFault(deviceFaultBean);
        return new Result(200,"OK",null);
    }

    /*修改故障条目*/
    @RequestMapping("/update")
    @ResponseBody
    public Result updateDeviceFault(String deviceFaultId,String deviceId,String deviceFaultDate,String deviceFaultCause,String deviceFaultMaintenance,String deviceFaultDetail){
        DeviceFault deviceFaultBean = getDeviceFaultBean(deviceFaultId,deviceId,deviceFaultDate,deviceFaultCause,deviceFaultMaintenance,deviceFaultDetail);
        deviceFaultService.updateDeviceFault(deviceFaultBean);
        return new Result(200,"OK",null);
    }

    /*批量删除故障*/
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Result deleteDeviceFault(String[] ids){
        deviceFaultService.deleteDeviceFaults(ids);
        return new Result(200,"OK",null);
    }

    /*根据不同条件查找故障*/
    @RequestMapping({"/search_deviceFault_by_deviceFaultId","/search_deviceFault_by_deviceName"})
    @ResponseBody
    public QueryJsonBean<DeviceFault> queryEmployee(String searchValue, Integer page, Integer rows, HttpServletRequest request){
        PageHelper pageHelper=new PageHelper();
        List<DeviceFault> deviceFaultList = null;
        Page<DeviceFault> resultPage = PageHelper.startPage(page, rows);
        //根据id或，name或部门进行相应的查找
        if (request.getRequestURI().contains("deviceFaultId")) deviceFaultList=deviceFaultService.queryDeviceFaultsByFaultId(searchValue);
        if (request.getRequestURI().contains("deviceName")) deviceFaultList=deviceFaultService.queryDeviceFaultsByDeviceName(searchValue);
        QueryJsonBean<DeviceFault> departmentQueryJsonBean = new QueryJsonBean<>();
        departmentQueryJsonBean.setTotal((int)resultPage.getTotal());
        departmentQueryJsonBean.setRows(deviceFaultList);
        return departmentQueryJsonBean;
    }

}
