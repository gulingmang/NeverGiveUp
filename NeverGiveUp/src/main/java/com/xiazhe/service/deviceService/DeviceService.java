package com.xiazhe.service.deviceService;

import com.xiazhe.bean.DeviceCheck;
import com.xiazhe.bean.DeviceList;
import com.xiazhe.bean.DeviceType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceService {

    /*显示所有设备台账*/
    List<DeviceList> queryAllDeviceList();

    /*显示所有设备种类*/
    DeviceType[] queryAllDeviceType();

    /*新增设备种类*/
    int addDeviceType(@Param("deviceType") DeviceType deviceType);

    /*显示所有设备例检*/
    List<DeviceCheck> queryAllDeviceCheck();
}
