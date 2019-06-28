package com.xiazhe.service.material;

import com.xiazhe.bean.material.MaterialReceive;
import com.xiazhe.mapper.MaterialReceiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {
    @Autowired
    MaterialReceiveMapper materialReceiveMapper;
    @Override
    public int deleteByPrimaryKey(String receiveId) {
        return materialReceiveMapper.deleteByPrimaryKey("id");
    }

    @Override
    public int insert(MaterialReceive record) {
        return materialReceiveMapper.insert(record);
    }

    @Override
    public int insertSelective(MaterialReceive record) {
        return materialReceiveMapper.insertSelective(record);
    }

    @Override
    public MaterialReceive selectByPrimaryKey(String receiveId) {
        return materialReceiveMapper.selectByPrimaryKey(receiveId);
    }

    @Override
    public int updateByPrimaryKeySelective(MaterialReceive record) {
        return materialReceiveMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MaterialReceive record) {
        return materialReceiveMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<MaterialReceive> selectAll() {
        return materialReceiveMapper.selectAll();
    }

    @Override
    public MaterialReceive selectByMaterialId(String materialId) {
        return materialReceiveMapper.selectByMaterialId(materialId);
    }
}
