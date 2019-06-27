package com.xiazhe.service.deviceService;

import com.xiazhe.bean.DeviceCheck;
import com.xiazhe.bean.DeviceList;
import com.xiazhe.bean.DeviceType;
import com.xiazhe.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceMapper deviceMapper;

    /*显示所有设备台账*/
    @Override
    public List<DeviceList> queryAllDeviceList() {
        List<DeviceList> deviceList = deviceMapper.queryAllDeviceList();
        return deviceList;
    }

    /*显示所有设备种类*/
    @Override
    public DeviceType[] queryAllDeviceType() {
        DeviceType[] deviceTypes = deviceMapper.queryAllDeviceType();

        return deviceTypes;
    }

    /*新增设备种类*/
    @Override
    public int addDeviceType(DeviceType deviceType) {
        int addDeviceType = deviceMapper.addDeviceType(deviceType);
        return addDeviceType;
    }

    /*显示所有设备例检*/
    @Override
    public List<DeviceCheck> queryAllDeviceCheck() {
        List<DeviceCheck> deviceChecks = deviceMapper.queryAllDeviceCheck();
        return deviceChecks;
    }
}
