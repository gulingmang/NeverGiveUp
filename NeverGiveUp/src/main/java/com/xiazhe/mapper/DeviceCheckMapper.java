package com.xiazhe.mapper;

import com.xiazhe.bean.DeviceCheck;

import java.util.List;

public interface DeviceCheckMapper {
    /*显示所有设备例检*/
    List<DeviceCheck> queryAllDeviceCheck();
}
