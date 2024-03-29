package com.xiazhe.service.technologyService;

import com.xiazhe.bean.TechnologyRequirement;
import com.xiazhe.bean.TechnologyResult;
import com.xiazhe.mapper.TechnologyRequirementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {
    @Autowired
    TechnologyRequirementMapper technologyRequirementMapper;
    @Override
    public int deleteByPrimaryKey(String[] technologyRequirementIds) {
        return technologyRequirementMapper.deleteByPrimaryKey(technologyRequirementIds);
    }

    @Override
    public int insert(TechnologyRequirement record) {
        return technologyRequirementMapper.insert(record);
    }

    @Override
    public TechnologyRequirement[] selectByPrimaryKey(String technologyRequirementId) {
        return technologyRequirementMapper.selectByPrimaryKey(technologyRequirementId);
    }

    @Override
    public List<TechnologyRequirement> queryAllTechnology() {
        return technologyRequirementMapper.queryAllTechnology();
    }

    @Override
    public List<TechnologyResult> queryAllTechnologyResult() {
        return technologyRequirementMapper.queryAllTechnologyResult();
    }

    @Override
    public int updateByPrimaryKey(TechnologyRequirement record) {
        return technologyRequirementMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateRequirementByPrimaryKey(TechnologyRequirement record) {
        return technologyRequirementMapper.updateRequirementByPrimaryKey(record);
    }

    @Override
    public TechnologyRequirement[] selectByName(String searchValue) {
        return technologyRequirementMapper.selectByName(searchValue);
    }
}
