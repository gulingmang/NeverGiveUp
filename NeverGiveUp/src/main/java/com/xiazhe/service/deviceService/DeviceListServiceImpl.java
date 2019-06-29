package com.xiazhe.service.deviceService;

import com.xiazhe.bean.DeviceList;
import com.xiazhe.mapper.DeviceListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceListServiceImpl implements DeviceListService {
    @Autowired
    DeviceListMapper deviceListMapper;

    /*显示所有设备台账*/
    @Override
    public List<DeviceList> queryAllDeviceList() {
        List<DeviceList> deviceList = deviceListMapper.queryAllDeviceList();
        return deviceList;
    }

    @Override
    public int addDeviceList(DeviceList deviceList) {
        return deviceListMapper.addDeviceList(deviceList);
    }

    @Override
    public int editDeviceList(DeviceList deviceList) {
        return deviceListMapper.editDeviceList(deviceList);
    }

    @Override
    public int deleteDeviceListByIds(String[] deviceListIds) {

        return deviceListMapper.deleteDeviceListByIds(deviceListIds);
    }

    @Override
    public List<DeviceList> selectByDeviceListId(String searchValue) {
        return deviceListMapper.selectByDeviceListId(searchValue);
    }

    @Override
    public List<DeviceList> selectByDeviceListName(String searchValue) {

        return deviceListMapper.selectByDeviceListName(searchValue);
    }

    @Override
    public List<DeviceList> selectByDeviceListSpecName(String searchValue) {
        return deviceListMapper.selectByDeviceListSpecName(searchValue);
    }

    @Override
    public DeviceList selectOneDeviceListById(String id) {
        return deviceListMapper.selectOneDeviceListById(id);
    }

}
