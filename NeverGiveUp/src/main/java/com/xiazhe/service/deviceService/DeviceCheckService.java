package com.xiazhe.service.deviceService;

import com.xiazhe.bean.DeviceCheck;

import java.util.List;

public interface DeviceCheckService {

    /*显示所有设备例检*//*
    List<DeviceCheck> queryAllDeviceCheck();*/

    /*显示所有设备台账*/
    List<DeviceCheck> queryAllDeviceCheck();

    /*deviceCheck新增*/
    int addDeviceCheck(DeviceCheck deviceCheck);

    /*deviceCheck编辑*/
    int editDeviceCheck(DeviceCheck deviceCheck);

    /*deviceCheck删除*/
    int deleteDeviceCheckByIds(String[] deviceCheckIds);

    /*通过id模糊查询设备例检*/
    List<DeviceCheck> selectByDeviceCheckId(String searchValue);

    /*通过name模糊查询设备例检*/
    List<DeviceCheck> selectByDeviceCheckName(String searchValue);
}
