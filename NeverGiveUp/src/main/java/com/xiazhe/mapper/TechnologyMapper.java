package com.xiazhe.mapper;

import com.xiazhe.bean.Technology.Technology;

import java.util.List;

public interface TechnologyMapper {
    int deleteByPrimaryKey(String technologyId);

    int insert(Technology record);

    int insertSelective(Technology record);

    Technology selectByPrimaryKey(String technologyId);
    List<Technology> queryTechnologyList();

    int updateByPrimaryKeySelective(Technology record);

    int updateByPrimaryKey(Technology record);
}