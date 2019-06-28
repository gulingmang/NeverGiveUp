package com.xiazhe.service.technologyService;

import com.xiazhe.bean.Technology;

import java.util.List;

public interface TechnologyService {
    int deleteByPrimaryKey(String[] technologyIds);//通过id批量删除工艺

    int insert(Technology record);//插入单个工艺

    List<Technology> queryAllTechnology();//查询所有工艺
    Technology[] selectByPrimaryKey(String technologyId);//通过一个id进行模糊查询

    Technology queryTechnologyById(String technologyId);//查询工艺信息除了id
    int updateByPrimaryKey(Technology record);//通过id修改工艺
}
