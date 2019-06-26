package com.xiazhe.service.TechnologyService;

import com.xiazhe.bean.Technology.Technology;

import java.util.List;

public interface TechnologyService {
    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    //int insertSelective(Technology record);

    Technology selectByPrimaryKey(String technologyId);

    //int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);

    List<Technology> queryTechnologyList();
}
