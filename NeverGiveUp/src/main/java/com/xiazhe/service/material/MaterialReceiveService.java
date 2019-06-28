package com.xiazhe.service.material;

import com.xiazhe.bean.material.MaterialReceive;

import java.util.List;

public interface MaterialReceiveService {
    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);
    List<MaterialReceive> selectAll();
    MaterialReceive selectByMaterialId(String receiveId);
}
