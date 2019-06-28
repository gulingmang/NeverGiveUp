package com.xiazhe.service.deviceService;

import com.xiazhe.bean.DeviceCheck;
import com.xiazhe.bean.DeviceList;
import com.xiazhe.bean.DeviceType;
import com.xiazhe.mapper.DeviceListMapper;
import com.xiazhe.mapper.DeviceTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Autowired
    DeviceListMapper deviceListMapper;

    /*显示所有设备台账*/
    @Override
    public List<DeviceList> queryAllDeviceList() {
        List<DeviceList> deviceList = deviceListMapper.queryAllDeviceList();
        return deviceList;
    }

    /*显示所有设备种类*/
    @Override
    public DeviceType[] queryAllDeviceType() {
        DeviceType[] deviceTypes = deviceTypeMapper.queryAllDeviceType();
        return deviceTypes;
    }

    /*新增设备种类*/
    @Override
    public int addDeviceType(DeviceType deviceType) {
        int addDeviceType = deviceTypeMapper.addDeviceType(deviceType);
        return addDeviceType;
    }

    /*编辑设备种类*/
    @Override
    public int updateDeviceType(DeviceType deviceType) {
        int updateDeviceType = deviceTypeMapper.updateDeviceType(deviceType);
        return updateDeviceType;
    }

    @Override
    public int deleteDeviceTypeByIds(String[] deviceTypeIds) {
        int typeids= deviceTypeMapper.deleteDeviceTypeByIds(deviceTypeIds);
        return typeids;
    }

    @Override
    public DeviceType[] selectByDeviceTypeId(String searchValue) {

        DeviceType[] deviceTypes = deviceTypeMapper.selectByDeviceTypeId(searchValue);
        return deviceTypes;
    }

    @Override
    public DeviceType[] selectByDeviceTypeName(String searchValue) {
        DeviceType[] deviceTypes = deviceTypeMapper.selectByDeviceTypeName(searchValue);
        return deviceTypes;
    }

    @Override
    public List<DeviceCheck> queryAllDeviceCheck() {
        return null;
    }

    @Override
    public int addDeviceList(DeviceList deviceList) {

        return 0;
    }

    /*显示所有设备例检*/
    /*@Override
    public List<DeviceCheck> queryAllDeviceCheck() {
        List<DeviceCheck> deviceChecks = deviceTypeMapper.queryAllDeviceCheck();
        return deviceChecks;
    }*/
}
