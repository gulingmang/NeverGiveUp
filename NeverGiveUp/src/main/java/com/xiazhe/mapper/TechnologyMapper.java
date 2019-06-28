package com.xiazhe.mapper;

import com.xiazhe.bean.Technology;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyMapper {

    Technology[] selectByPrimaryKey(@Param("searchValue") String technologyId);//通过一个id进行模糊查询
    int deleteByPrimaryKey(@Param("ids") String[] technologyIds);//通过id批量删除工艺

    int insert(Technology record);//插入单个工艺
    List<Technology> queryAllTechnology();//查询所有工艺

    Technology queryTechnologyById(String technologyId);//查询工艺信息除了id
    int updateByPrimaryKey(Technology record);//通过id修改工艺
    Technology[] selectByName(@Param("searchValue") String technologyName);//通过一个Name进行模糊查询
}