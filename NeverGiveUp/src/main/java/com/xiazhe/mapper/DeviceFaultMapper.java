package com.xiazhe.mapper;

import com.xiazhe.bean.DeviceFault;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceFaultMapper {
    public int addDeviceFault(@Param("fault") DeviceFault deviceFault);

    public int deleteDeviceFaults(@Param("ids") String[] ids);

    public int updateDeviceFault(@Param("fault") DeviceFault deviceFault);

    public DeviceFault queryDeviceFaultById(@Param("id") String id);

    public List<DeviceFault> queryDeviceFaultsByFaultId(@Param("id") String id);

    public List<DeviceFault> queryDeviceFaultsByDeviceName(@Param("name") String name);

    public List<DeviceFault> queryAllDeviceFaults();

    DeviceFault selectOneDeviceFaultById(@Param("id") String id);
}
