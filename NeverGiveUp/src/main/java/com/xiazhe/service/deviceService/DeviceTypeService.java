package com.xiazhe.service.deviceService;

import com.xiazhe.bean.DeviceCheck;
import com.xiazhe.bean.DeviceList;
import com.xiazhe.bean.DeviceType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceTypeService {

    /*显示所有设备种类*/
    DeviceType[] queryAllDeviceType();

    /*新增设备种类*/
    int addDeviceType(@Param("deviceType") DeviceType deviceType);

    //编辑设备种类
    int updateDeviceType(DeviceType deviceType);

    /*删除设备种类*/
    int deleteDeviceTypeByIds(@Param("id") String[] deviceTypeIds);

    /*通过设备种类id模糊查询设备种类*/
    DeviceType[] selectByDeviceTypeId(String searchValue);

    /*通过设备种类name模糊查询设备种类*/
    DeviceType[] selectByDeviceTypeName(String searchValue);

    /*显示所有设备例检*/
    List<DeviceCheck> queryAllDeviceCheck();

}
