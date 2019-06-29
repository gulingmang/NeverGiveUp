package com.xiazhe.mapper;

import com.xiazhe.bean.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(Task record);

    int insertSelective(Task record);

    Task selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(Task record);

    int updateByPrimaryKey(Task record);

    List<Task> queryTasks();

    List<Task> searchTasks(@Param("value") String value, @Param("op")String op);
}