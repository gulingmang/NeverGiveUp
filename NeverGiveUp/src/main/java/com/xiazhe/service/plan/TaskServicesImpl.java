package com.xiazhe.service.plan;

import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.Task;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class TaskServicesImpl implements TaskServices{
    @Autowired
    TaskMapper taskMapper;

    @Override
    public QueryJsonBean<Task> queryTasks(int page, int rows) {
        List<Task> list = taskMapper.queryTasks();
        QueryJsonBean<Task> queryJsonBean = new QueryJsonBean<>();
        queryJsonBean.setTotal(list.size());
        PageHelper pageHelper = new PageHelper();
        pageHelper.offsetPage((page-1)*rows,rows);
        list  = taskMapper.queryTasks();
        queryJsonBean.setRows(list);
        return queryJsonBean;
    }

    @Override
    public int insertNewTask(Task task) {
        int insert = taskMapper.insert(task);
        if(insert > 0){
            return insert;
        }else {
            return 0;
        }
    }

    @Override
    public int updateTask(Task task) {
        int i = taskMapper.updateByPrimaryKey(task);
        if(i>0){
            return i;
        }else{
            return 0;
        }
    }

    @Override
    public int deleteTasks(String[] ids) {
        // 删除的时候记录删除的个数
        int count = 0;
        for (int i = 0; i <ids.length ; i++) {
            count += taskMapper.deleteByPrimaryKey(ids[i]);
        }
        if (count>0){
            return count;
        }else {
            return 0;
        }
    }

    @Override
    public QueryJsonBean<Task> searchTasks(String value, String op, int page, int rows) {
        List<Task> list = taskMapper.searchTasks(value, op);
        QueryJsonBean<Task> queryJsonBean = new QueryJsonBean<>();
        queryJsonBean.setTotal(list.size());
        PageHelper pageHelper = new PageHelper();
        pageHelper.offsetPage((page-1)*rows,rows);
        list = taskMapper.searchTasks(value,op);
        queryJsonBean.setRows(list);
        return queryJsonBean;
    }
}
