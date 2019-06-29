package com.xiazhe.service.deviceService;

import com.xiazhe.bean.DeviceCheck;
import com.xiazhe.mapper.DeviceCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService {
    @Autowired
    DeviceCheckMapper deviceCheckMapper;

    @Override
    public int addDeviceCheck(DeviceCheck deviceCheck) {

        return deviceCheckMapper.addDeviceCheck(deviceCheck);
    }

    @Override
    public int deleteDeviceChecks(String[] ids) {
        return deviceCheckMapper.deleteDeviceChecks(ids);
    }

    @Override
    public int updateDeviceCheck(DeviceCheck deviceCheck) {
        return deviceCheckMapper.updateDeviceCheck(deviceCheck);
    }

    @Override
    public List<DeviceCheck> queryDeviceChecksByCheckId(String id) {
        return deviceCheckMapper.queryDeviceChecksByCheckId(id);
    }

    @Override
    public List<DeviceCheck> queryDeviceChecksByDeviceName(String name) {
        return deviceCheckMapper.queryDeviceChecksByDeviceName(name);
    }

    @Override
    public List<DeviceCheck> queryAllDeviceChecks() {
        return deviceCheckMapper.queryAllDeviceChecks();
    }
}
