package com.xiazhe.mapper;

import com.xiazhe.bean.DeviceList;

import java.util.List;

public interface DeviceListMapper {
    /*显示所有设备台账*/
    List<DeviceList> queryAllDeviceList();

    /*deviceList新增*/
    int addDeviceList(DeviceList deviceList);
}
