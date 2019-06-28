package com.xiazhe.service.material;

import com.xiazhe.bean.Work;
import com.xiazhe.bean.material.MaterialConsume;
import com.xiazhe.mapper.MaterialConsumeMapper;
import com.xiazhe.service.material.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {
    @Autowired
    MaterialConsumeMapper materialConsumeMapper;
    @Override
    public int deleteByPrimaryKey(String consumeId) {
        return materialConsumeMapper.deleteByPrimaryKey(consumeId);
    }

    @Override
    public int insert(MaterialConsume record) {
        return materialConsumeMapper.insert(record);
    }

    @Override
    public int insertSelective(MaterialConsume record) {
        return materialConsumeMapper.insertSelective(record);
    }

    @Override
    public MaterialConsume selectByPrimaryKey(String consumeId) {
        return materialConsumeMapper.selectByPrimaryKey(consumeId);
    }

    @Override
    public int updateByPrimaryKeySelective(MaterialConsume record) {
        return materialConsumeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MaterialConsume record) {
        return materialConsumeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<MaterialConsume> selectAll() {
        return materialConsumeMapper.selectAll();
    }

    @Override
    public List<MaterialConsume> selectByMaterialId(String materialId) {
        return materialConsumeMapper.selectByMaterialId(materialId);
    }

    @Override
    public List<MaterialConsume> selectByWorkId(String workId) {
        return materialConsumeMapper.selectByWorkId(workId);
    }


}
