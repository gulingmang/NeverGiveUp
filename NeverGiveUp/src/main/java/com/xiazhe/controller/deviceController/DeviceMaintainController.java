package com.xiazhe.controller.deviceController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.DeviceMaintain;
import com.xiazhe.bean.Result;
import com.xiazhe.bean.Technology;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.deviceService.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * deviceMaintain设备维修
 * 包括显示页面及页面数据内容、新增、编辑、删除、查询、分页操作
 */
@Controller
@RequestMapping("deviceMaintain")
public class DeviceMaintainController {
    @Autowired
    DeviceMaintainService deviceMaintainService;
    //显示所有维修列表
    @RequestMapping("/list")
    @ResponseBody
    public QueryJsonBean<DeviceMaintain> queryAllTechnology(int page, int rows){
        PageHelper pageHelper = new PageHelper();
        Page<DeviceMaintain> technologypage = pageHelper.startPage(page, rows);
        List<DeviceMaintain> deviceMaintains = deviceMaintainService.queryAll();
        QueryJsonBean<DeviceMaintain> technologyQueryJsonBean = new QueryJsonBean<>();
        technologyQueryJsonBean.setRows(deviceMaintains);
        technologyQueryJsonBean.setTotal((int) technologypage.getTotal());
        return technologyQueryJsonBean;
    }

    //通过维修编号id模糊查询
    @RequestMapping("/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public List<DeviceMaintain> queryById(String searchValue){
        List<DeviceMaintain> deviceMaintains = deviceMaintainService.selectByPrimaryKey(searchValue);
        return deviceMaintains;
    }
    //通过故障编号id模糊查询
    @RequestMapping("/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public List<DeviceMaintain> queryByFaultId(String searchValue){
        List<DeviceMaintain> deviceMaintains = deviceMaintainService.selectBydeviceFaultId(searchValue);
        return deviceMaintains;
    }

    //插入一条设备维修记录
    @RequestMapping("/add_judge")
    public String toaddjudge(){
        return "/WEB-INF/jsp/deviceMaintain_add.jsp";
    }
    @RequestMapping("/add")
    public String toadd(){
        return "/WEB-INF/jsp/deviceMaintain_add.jsp";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public Result insertDeviceM(DeviceMaintain deviceMaintain){
        deviceMaintainService.insert(deviceMaintain);
        Result result = new Result();
        result.setStatus(200);
        result.setMsg("OK");
        result.setData(null);
        return result;
    }

    //编辑设备维修
    @RequestMapping("/edit_judge")
    @ResponseBody
    public String editDeviceType1(){
        return "{}";
    }
    @RequestMapping("/edit")
    public String editDeviceType2(){
        return "/WEB-INF/jsp/deviceMaintain_edit.jsp";
    }
    @RequestMapping("/update")
    @ResponseBody
    public Result editDeviceMaintain(DeviceMaintain deviceMaintain){
        deviceMaintainService.editDeviceMaintain(deviceMaintain);
        return new Result(200,"OK",null);
    }

    //删除
    @RequestMapping("/delete_judge")
    @ResponseBody
    public String deleteDeviceList1(){
        return "{}";
    }

    //5.2删除操作
    @RequestMapping("/delete_batch")
    @ResponseBody
    public Result deleteDeviceListByIds(String[] ids){
        deviceMaintainService.deleteByPrimaryKey(ids);
        return new Result(200,"OK",null);
    }


}
