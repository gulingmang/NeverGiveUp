package com.xiazhe.mapper;

import com.xiazhe.bean.DeviceCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceCheckMapper {
    /*显示所有设备例检*/
    List<DeviceCheck> queryAllDeviceCheck();

    /*deviceCheck新增*/
    int addDeviceCheck(@Param("device") DeviceCheck deviceCheck);

    /*deviceCheck编辑*/
    int editDeviceCheck(@Param("device") DeviceCheck deviceCheck);

    /*deviceCheck删除*/
    int deleteDeviceCheckByIds(@Param("id") String[] deviceCheckIds);

    /*通过id模糊查询设备例检*/
    List<DeviceCheck> selectByDeviceCheckId(@Param("searchValue") String searchValue);

    /*通过name模糊查询设备台*/
    List<DeviceCheck> selectByDeviceCheckName(@Param("searchValue") String searchValue);

    /*通过设备种类名称查询设备例检*/
    List<DeviceCheck> selectByDeviceCheckSpecName(@Param("searchValue") String searchValue);
}
