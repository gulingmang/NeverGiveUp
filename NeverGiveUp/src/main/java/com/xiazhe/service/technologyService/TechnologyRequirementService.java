package com.xiazhe.service.technologyService;

import com.xiazhe.bean.TechnologyRequirement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyRequirementService {
    int deleteByPrimaryKey(@Param("") String[] technologyRequirementIds);//批量删除工艺要求

    int insert(TechnologyRequirement record);//增加工艺要求



    TechnologyRequirement[] selectByPrimaryKey(@Param("") String technologyRequirementId);//模糊查询工艺要求

    List<TechnologyRequirement> queryAllTechnology();//查询所有工艺要求(与工艺多表查询)

    int updateByPrimaryKey(TechnologyRequirement record);//通过id修改工艺要求

}
