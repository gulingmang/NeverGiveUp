package com.xiazhe.mapper;

import com.xiazhe.bean.DeviceList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceListMapper {
    /*显示所有设备台账*/
    List<DeviceList> queryAllDeviceList();

    /*deviceList新增*/
    int addDeviceList(@Param("device") DeviceList deviceList);

    /*deviceList编辑*/
    int editDeviceList(@Param("device") DeviceList deviceList);

    /*deviceList删除*/
    int deleteDeviceListByIds(@Param("id") String[] deviceListIds);

    /*通过id模糊查询设备台账*/
    List<DeviceList> selectByDeviceListId(@Param("searchValue") String searchValue);

    /*通过name模糊查询设备台*/
    List<DeviceList> selectByDeviceListName(@Param("searchValue") String searchValue);

    /*通过设备种类名称查询设备台账*/
    List<DeviceList> selectByDeviceListSpecName(@Param("searchValue") String searchValue);

}
