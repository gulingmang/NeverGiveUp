package com.xiazhe.mapper;

import com.xiazhe.bean.DeviceCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceCheckMapper {
    public int addDeviceCheck(@Param("Check") DeviceCheck deviceCheck);

    public int deleteDeviceChecks(@Param("ids") String[] ids);

    public int updateDeviceCheck(@Param("Check") DeviceCheck deviceCheck);

    public List<DeviceCheck> queryDeviceChecksByCheckId(@Param("id") String id);

    public List<DeviceCheck> queryDeviceChecksByDeviceName(@Param("name") String name);

    public List<DeviceCheck> queryAllDeviceChecks();
}
