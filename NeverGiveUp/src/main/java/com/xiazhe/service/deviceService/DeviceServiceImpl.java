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

    /*编辑设备种类*/
    @Override
    public int updateDeviceType(DeviceType deviceType) {
        int updateDeviceType = deviceMapper.updateDeviceType(deviceType);
        return updateDeviceType;
    }

    @Override
    public int deleteDeviceTypeByIds(String[] deviceTypeIds) {
        int typeids= deviceMapper.deleteDeviceTypeByIds(deviceTypeIds);
        return typeids;
    }

    @Override
    public DeviceType[] selectByDeviceTypeId(String searchValue) {

        DeviceType[] deviceTypes = deviceMapper.selectByDeviceTypeId(searchValue);
        return deviceTypes;
    }

    @Override
    public DeviceType[] selectByDeviceTypeName(String searchValue) {
        DeviceType[] deviceTypes = deviceMapper.selectByDeviceTypeName(searchValue);
        return deviceTypes;
    }

    /*显示所有设备例检*/
    @Override
    public List<DeviceCheck> queryAllDeviceCheck() {
        List<DeviceCheck> deviceChecks = deviceMapper.queryAllDeviceCheck();
        return deviceChecks;
    }
}
