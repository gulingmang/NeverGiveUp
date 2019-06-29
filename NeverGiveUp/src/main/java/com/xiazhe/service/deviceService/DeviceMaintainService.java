package com.xiazhe.service.deviceService;

import com.xiazhe.bean.DeviceMaintain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMaintainService {
    int deleteByPrimaryKey(@Param("ids")String[] deviceMaintainId);//通过id批量删除设备维修

    int insert(DeviceMaintain record);//插入设备维修

    int editDeviceMaintain(DeviceMaintain deviceMaintain);  //编辑

    List<DeviceMaintain> selectByPrimaryKey(String deviceMaintainId);//通过id模糊查询

    List<DeviceMaintain> selectBydeviceFaultId(@Param("searchValue")String deviceMaintainId);//通过故障编号模糊查询

    List<DeviceMaintain> queryAll();//查询所有维修记录
}
