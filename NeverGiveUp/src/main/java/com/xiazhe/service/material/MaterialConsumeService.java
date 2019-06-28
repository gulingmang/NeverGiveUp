package com.xiazhe.service.material;

import com.xiazhe.bean.material.MaterialConsume;

import java.util.List;

public interface MaterialConsumeService {
    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsume record);

    int insertSelective(MaterialConsume record);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByPrimaryKeySelective(MaterialConsume record);

    int updateByPrimaryKey(MaterialConsume record);
    List<MaterialConsume> selectAll();
    List<MaterialConsume> selectByMaterialId(String materialId);
    List<MaterialConsume> selectByWorkId(String workId);
}
