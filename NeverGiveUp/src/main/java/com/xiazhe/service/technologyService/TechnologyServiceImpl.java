package com.xiazhe.service.technologyService;

import com.xiazhe.bean.Technology;
import com.xiazhe.mapper.TechnologyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {
    @Autowired
    TechnologyMapper technologyMapper;
    @Override
    public int deleteByPrimaryKey(String[] technologyIds) {
        return technologyMapper.deleteByPrimaryKey(technologyIds);
    }

    @Override
    public int insert(Technology record) {
        return technologyMapper.insert(record);
    }

    @Override
    public List<Technology> queryAllTechnology() {
        return technologyMapper.queryAllTechnology();
    }

    @Override
    public Technology[] selectByPrimaryKey(String technologyId) {
        return technologyMapper.selectByPrimaryKey(technologyId);
    }

    @Override
    public Technology queryTechnologyById(String technologyId) {
        return technologyMapper.queryTechnologyById(technologyId);
    }

    @Override
    public int updateByPrimaryKey(Technology record) {
        return technologyMapper.updateByPrimaryKey(record);
    }

    @Override
    public Technology[] selectByName(String technologyName) {
        return technologyMapper.selectByName(technologyName);
    }
}
