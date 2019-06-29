package com.xiazhe.service.technologyService;

import com.xiazhe.bean.Process;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessService {
    int deleteByPrimaryKey(@Param("ids")String[] processId);//通过id批量删除工序管理

    int insert(Process record);//插入工序


    Process[] selectByPrimaryKey(@Param("searchValue")String processId);//通过一个id进行模糊查询
    List<Process> queryAllProcess();//查询所有工序

    int updateByPrimaryKey(Process record);////通过id修改工序

    Process[] selectByName(String searchValue);//通过工艺计划id进行模糊查询
/* 由id得到一个对象*/
    Process selectById(String id);
}
