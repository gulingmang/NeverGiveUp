package com.xiazhe.controller.deviceController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.DeviceCheck;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.deviceService.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/deviceCheck")
public class DeviceCheckController {
    @Autowired
    DeviceCheckService deviceCheckService;

    /*操作判断*/
    @RequestMapping("/*_judge")
    @ResponseBody
    public String judge() {
        return "{}";
    }

    /*所有故障列表数据*/
    @RequestMapping("/get_data")
    @ResponseBody
    public List<DeviceCheck> allDeviceCheckListData() {
        return deviceCheckService.queryAllDeviceChecks();
    }

    /*故障列表数据*/
    @RequestMapping("/list")
    @ResponseBody
    public QueryJsonBean pageDeviceCheckListData(Integer page, Integer rows) {
        PageHelper pageHelper = new PageHelper();
        Page<DeviceCheck> resultPage = pageHelper.startPage(page, rows);
        List<DeviceCheck> deviceCheckList = deviceCheckService.queryAllDeviceChecks();
        QueryJsonBean<DeviceCheck> departmentQueryJsonBean = new QueryJsonBean<>();
        departmentQueryJsonBean.setTotal((int) resultPage.getTotal());
        departmentQueryJsonBean.setRows(deviceCheckList);
        return departmentQueryJsonBean;
    }

    /*故障添加页面*/
    @RequestMapping("/add")
    public String showAddDeviceCheckPage() {
        return "/WEB-INF/jsp/deviceCheck_add.jsp";
    }

    /*故障编辑页面*/
    @RequestMapping("/edit")
    public String showEditDeviceCheckPage() {
        return "/WEB-INF/jsp/deviceCheck_edit.jsp";
    }

    /*插入故障条目*/
    @RequestMapping("/insert")
    @ResponseBody
    public Result addDeviceCheck(String deviceCheckId, String deviceId, String deviceCheckEmpId, Date deviceCheckDate, String deviceCheckResult, String deviceCheckFaultId, String deviceName, String deviceCheckEmp) {
        DeviceCheck deviceCheck = new DeviceCheck(deviceCheckId, deviceId, deviceCheckEmpId, deviceCheckDate, deviceCheckResult, deviceCheckFaultId, deviceName, deviceCheckEmp);
        deviceCheckService.addDeviceCheck(deviceCheck);
        return new Result(200, "OK", null);
    }

    /*修改故障条目*/
    @RequestMapping("/update")
    @ResponseBody
    public Result updateDeviceCheck(String deviceCheckId, String deviceId, String deviceCheckEmpId, Date deviceCheckDate, String deviceCheckResult, String deviceCheckFaultId, String deviceName, String deviceCheckEmp) {
        DeviceCheck deviceCheck = new DeviceCheck(deviceCheckId, deviceId, deviceCheckEmpId, deviceCheckDate, deviceCheckResult, deviceCheckFaultId, deviceName, deviceCheckEmp);
        deviceCheckService.updateDeviceCheck(deviceCheck);
        return new Result(200, "OK", null);
    }

    /*批量删除故障*/
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Result deleteDeviceCheck(String[] ids) {
        deviceCheckService.deleteDeviceChecks(ids);
        return new Result(200, "OK", null);
    }

    @RequestMapping("/search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public QueryJsonBean selectByDeviceListId(String searchValue, int page, int rows) {
        PageHelper pageHelper = new PageHelper();
        Page<DeviceCheck> resultPage = pageHelper.startPage(page, rows);
        List<DeviceCheck> deviceLists = deviceCheckService.queryDeviceChecksByCheckId(searchValue);
        QueryJsonBean<DeviceCheck> deviceListQueryJsonBean = new QueryJsonBean<>();
        deviceListQueryJsonBean.setRows(deviceLists);
        deviceListQueryJsonBean.setTotal((int) resultPage.getTotal());
        return deviceListQueryJsonBean;
    }

    //6.2通过设备种类名称deviceCheckName模糊查询
    @RequestMapping("/search_deviceCheck_by_deviceName")
    @ResponseBody
    public QueryJsonBean selectByDeviceListName(String searchValue, int page, int rows) {
        PageHelper pageHelper = new PageHelper();
        Page<DeviceCheck> resultPage = pageHelper.startPage(page, rows);
        List<DeviceCheck> deviceLists = deviceCheckService.queryDeviceChecksByDeviceName(searchValue);
        QueryJsonBean<DeviceCheck> deviceListQueryJsonBean = new QueryJsonBean<>();
        deviceListQueryJsonBean.setRows(deviceLists);
        deviceListQueryJsonBean.setTotal((int) resultPage.getTotal());
        return deviceListQueryJsonBean;
    }

}

