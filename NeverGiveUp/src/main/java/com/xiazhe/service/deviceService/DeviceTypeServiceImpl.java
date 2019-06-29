package com.xiazhe.service.deviceService;

import com.xiazhe.bean.DeviceCheck;
import com.xiazhe.bean.DeviceType;
import com.xiazhe.mapper.DeviceTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    @Autowired
    DeviceTypeMapper deviceTypeMapper;

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
    public int editDeviceType(DeviceType deviceType) {
        int updateDeviceType = deviceTypeMapper.editDeviceType(deviceType);
        return updateDeviceType;
    }

    @Override
    public int deleteDeviceTypeByIds(String[] deviceTypeIds) {
        int typeids = deviceTypeMapper.deleteDeviceTypeByIds(deviceTypeIds);
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
    public DeviceType selectOneDeviceTypeById(String id) {

        return deviceTypeMapper.selectOneDeviceTypeById(id);
    }
}
