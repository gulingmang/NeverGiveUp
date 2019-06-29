package com.xiazhe.service.deviceService;

import com.xiazhe.bean.DeviceFault;
import com.xiazhe.mapper.DeviceFaultMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

    @Autowired
    DeviceFaultMapper deviceFaultMapper;

    @Override
    public int addDeviceFault(DeviceFault deviceFault) {
        return deviceFaultMapper.addDeviceFault(deviceFault);
    }

    @Override
    public int deleteDeviceFaults(String[] ids) {
        return deviceFaultMapper.deleteDeviceFaults(ids);
    }

    @Override
    public int updateDeviceFault(DeviceFault deviceFault) {
        return deviceFaultMapper.updateDeviceFault(deviceFault);
    }

    @Override
    public DeviceFault queryDeviceFaultById(String id) {
        return deviceFaultMapper.queryDeviceFaultById(id);
    }

    @Override
    public List<DeviceFault> queryDeviceFaultsByFaultId(String id) {
        return deviceFaultMapper.queryDeviceFaultsByFaultId(id);
    }

    @Override
    public List<DeviceFault> queryDeviceFaultsByDeviceName(String name) {
        return deviceFaultMapper.queryDeviceFaultsByDeviceName(name);
    }

    @Override
    public List<DeviceFault> queryAllDeviceFaults() {
        return deviceFaultMapper.queryAllDeviceFaults();
    }

    @Override
    public DeviceFault selectOneDeviceFaultById(String id) {
        return deviceFaultMapper.selectOneDeviceFaultById(id);
    }
}
