package com.xiazhe.mapper;

import com.xiazhe.bean.TechnologyRequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementMapper {
    int deleteByPrimaryKey(@Param("ids") String[] technologyRequirementIds);//批量删除工艺要求

    int insert(TechnologyRequirement record);//增加工艺



    TechnologyRequirement[] selectByPrimaryKey(@Param("searchValue") String technologyRequirementId);//模糊查询工艺要求

    List<TechnologyRequirement> queryAllTechnology();//查询所有工艺要求(与工艺多表查询)

    int updateByPrimaryKey(TechnologyRequirement record);//通过id修改工艺要求
}