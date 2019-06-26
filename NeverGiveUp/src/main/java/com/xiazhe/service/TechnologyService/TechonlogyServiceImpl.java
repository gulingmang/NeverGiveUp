package com.xiazhe.service.TechnologyService;

import com.xiazhe.bean.Technology.Technology;
import com.xiazhe.mapper.TechnologyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechonlogyServiceImpl implements TechnologyService{
    @Autowired
    TechnologyMapper technologyMapper;
    @Override
    public int deleteByPrimaryKey(String technologyId) {
        return technologyMapper.deleteByPrimaryKey(technologyId);
    }

    @Override
    public int insert(Technology record) {
        return technologyMapper.insert(record);
    }

    @Override
    public Technology selectByPrimaryKey(String technologyId) {
        return technologyMapper.selectByPrimaryKey(technologyId);
    }

    @Override
    public int updateByPrimaryKey(Technology record) {
        return technologyMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Technology> queryTechnologyList() {
        return technologyMapper.queryTechnologyList();
    }
}
