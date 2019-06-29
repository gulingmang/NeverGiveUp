package com.xiazhe.service.deviceService;

import com.xiazhe.bean.DeviceMaintain;
import com.xiazhe.mapper.DeviceMaintainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {
    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;
    @Override
    public int deleteByPrimaryKey(String[] deviceMaintainId) {
        return deviceMaintainMapper.deleteByPrimaryKey(deviceMaintainId);
    }

    @Override
    public int insert(DeviceMaintain record) {
        return deviceMaintainMapper.insert(record);
    }

    @Override
    public int editDeviceMaintain(DeviceMaintain deviceMaintain) {

        return deviceMaintainMapper.editDeviceMaintain(deviceMaintain);
    }

    @Override
    public List<DeviceMaintain> selectByPrimaryKey(String deviceMaintainId) {
        return deviceMaintainMapper.selectByPrimaryKey(deviceMaintainId);
    }

    @Override
    public List<DeviceMaintain> selectBydeviceFaultId(String deviceMaintainId) {
        return deviceMaintainMapper.selectBydeviceFaultId(deviceMaintainId);
    }

    @Override
    public List<DeviceMaintain> queryAll() {
        return deviceMaintainMapper.queryAll();
    }
}
