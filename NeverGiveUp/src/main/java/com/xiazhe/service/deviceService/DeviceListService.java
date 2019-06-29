package com.xiazhe.service.deviceService;

import com.xiazhe.bean.DeviceList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceListService {
    /*显示所有设备台账*/
    List<DeviceList> queryAllDeviceList();

    /*deviceList新增*/
    int addDeviceList(DeviceList deviceList);

    /*deviceList编辑*/
    int editDeviceList(DeviceList deviceList);

    /*deviceList删除*/
    int deleteDeviceListByIds(String[] deviceListIds);

    /*通过id模糊查询设备台账*/
    List<DeviceList> selectByDeviceListId(String searchValue);

    /*通过name模糊查询设备台账*/
    List<DeviceList> selectByDeviceListName(String searchValue);

    //通过设备种类名称查询设备台账
    List<DeviceList> selectByDeviceListSpecName(String searchValue);

    DeviceList selectOneDeviceListById(String id);
}
