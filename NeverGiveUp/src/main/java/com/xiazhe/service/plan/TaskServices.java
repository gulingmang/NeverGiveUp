package com.xiazhe.service.plan;

import com.xiazhe.bean.Task;
import com.xiazhe.bean.json.QueryJsonBean;

public interface TaskServices {

    QueryJsonBean<Task> queryTasks(int page, int rows);

    int insertNewTask(Task task);

    int updateTask(Task task);

    int deleteTasks(String[] ids);

    QueryJsonBean<Task> searchTasks(String value, String op, int page , int rows);
}
