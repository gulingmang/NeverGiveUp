package com.xiazhe.service.material;

import com.xiazhe.bean.material.Material;
import com.xiazhe.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialMapper materialMapper;
    @Override
    public int deleteByPrimaryKey(String materialId) {
        return materialMapper.deleteByPrimaryKey(materialId);
    }

    @Override
    public int insert(Material record) {
        return materialMapper.insert(record);
    }

    @Override
    public int insertSelective(Material record) {
        return materialMapper.insertSelective(record);
    }

    @Override
    public Material selectByPrimaryKey(String materialId) {
        return materialMapper.selectByPrimaryKey(materialId);
    }

    @Override
    public int updateByPrimaryKeySelective(Material record) {
        return materialMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Material record) {
        return materialMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Material> selectAll() {
        return materialMapper.selectAll();
    }

    @Override
    public Material selectByType(String materialType) {
        return materialMapper.selectByType(materialType);
    }
}
