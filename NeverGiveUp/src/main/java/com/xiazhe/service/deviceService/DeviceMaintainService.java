package com.xiazhe.service.deviceService;

import com.xiazhe.bean.DeviceMaintain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMaintainService {
    int deleteByPrimaryKey(@Param("ids")String[] deviceMaintainId);//通过id批量删除设备维修

    int insert(DeviceMaintain record);//插入设备维修

    int insertSelective(DeviceMaintain record);

    List<DeviceMaintain> selectByPrimaryKey(String deviceMaintainId);//通过id模糊查询

    List<DeviceMaintain> selectBydeviceFaultId(@Param("searchValue")String deviceMaintainId);//通过故障编号模糊查询

    int updateByPrimaryKeySelective(DeviceMaintain record);//通过id修改设备维修

    int updateByPrimaryKey(DeviceMaintain record);//通过id修改设备维修

    List<DeviceMaintain> queryAll();//查询所有维修记录
}
