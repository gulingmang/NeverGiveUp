package com.xiazhe.service.material;

import com.xiazhe.bean.material.Material;

import java.util.List;

public interface MaterialService {
    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(String materialId);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

    List<Material> selectAll();
    Material selectByType(String materialType);
}
