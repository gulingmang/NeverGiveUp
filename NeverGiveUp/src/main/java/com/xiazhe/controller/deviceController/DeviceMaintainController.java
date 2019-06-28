package com.xiazhe.controller.deviceController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.DeviceMaintain;
import com.xiazhe.bean.Technology;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.service.deviceService.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeviceMaintainController {
    @Autowired
    DeviceMaintainService deviceMaintainService;
    //显示所有维修列表
    @RequestMapping("deviceMaintain/list")
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
    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public List<DeviceMaintain> queryById(String searchValue){
        List<DeviceMaintain> deviceMaintains = deviceMaintainService.selectByPrimaryKey(searchValue);
        return deviceMaintains;
    }
    //通过故障编号id模糊查询
    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public List<DeviceMaintain> queryByFaultId(String searchValue){
        List<DeviceMaintain> deviceMaintains = deviceMaintainService.selectBydeviceFaultId(searchValue);
        return deviceMaintains;
    }
}
