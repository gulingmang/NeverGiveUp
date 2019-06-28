package com.xiazhe.mapper;

import com.xiazhe.bean.TechnologyPlan;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface TechnologyPlanMapper {
    int deleteByPrimaryKey(@Param("ids") String[] technologyPlanId);//通过id批量删除工艺计划

    int insert(TechnologyPlan record);//插入单个工艺计划



    TechnologyPlan[] selectByPrimaryKey(@Param("searchValue") String technologyPlanId);//通过一个id进行模糊查询
    ArrayList<TechnologyPlan> queryAllTechnology();//查询所有工艺计划


    int updateByPrimaryKey(TechnologyPlan record);//通过id进行计划修改
}