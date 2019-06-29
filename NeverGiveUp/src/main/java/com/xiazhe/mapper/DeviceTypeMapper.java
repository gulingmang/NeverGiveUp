package com.xiazhe.mapper;

import com.xiazhe.bean.DeviceCheck;
import com.xiazhe.bean.DeviceList;
import com.xiazhe.bean.DeviceType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceTypeMapper {

    /*显示所有设备种类*/
    DeviceType[] queryAllDeviceType();

    /*新增设备种类*/
    int addDeviceType(@Param("deviceType") DeviceType deviceType);

    /*编辑设备种类*/
    int editDeviceType(@Param("deviceType") DeviceType deviceType);

    /*删除设备种类*/
    int deleteDeviceTypeByIds(@Param("ids") String[] deviceTypeIds);

    /*通过设备种类id模糊查询设备种类*/
    DeviceType[] selectByDeviceTypeId(@Param("searchValue") String searchValue);

    /*通过设备name模糊查询设备种类*/
    DeviceType[] selectByDeviceTypeName(@Param("searchValue") String searchValue);

    DeviceType selectOneDeviceTypeById(@Param("id") String id);
}
