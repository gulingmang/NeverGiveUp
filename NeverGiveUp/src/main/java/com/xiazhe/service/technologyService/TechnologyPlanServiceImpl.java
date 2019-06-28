package com.xiazhe.service.technologyService;

import com.xiazhe.bean.TechnologyPlan;
import com.xiazhe.mapper.TechnologyPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService {
    @Autowired
    TechnologyPlanMapper technologyPlanMapper;
    @Override
    public int deleteByPrimaryKey(String[] technologyPlanId) {
        return technologyPlanMapper.deleteByPrimaryKey(technologyPlanId);
    }

    @Override
    public int insert(TechnologyPlan record) {
        return technologyPlanMapper.insert(record);
    }

    @Override
    public TechnologyPlan[] selectByPrimaryKey(String technologyPlanId) {
        return technologyPlanMapper.selectByPrimaryKey(technologyPlanId);
    }

    @Override
    public ArrayList<TechnologyPlan> queryAllTechnology() {
        return technologyPlanMapper.queryAllTechnology();
    }

    @Override
    public int updateByPrimaryKey(TechnologyPlan record) {
        return technologyPlanMapper.updateByPrimaryKey(record);
    }

    @Override
    public TechnologyPlan queryPlanById(String technologyPlanId) {
        return technologyPlanMapper.queryPlanById(technologyPlanId);
    }

    @Override
    public TechnologyPlan[] selectByName(String searchValue) {
        return technologyPlanMapper.selectByName(searchValue);
    }
}
