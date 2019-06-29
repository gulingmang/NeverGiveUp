package com.xiazhe.service.processCountCheckService;

import com.xiazhe.bean.ProcessCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhengX
 * @create 2019-06-29 17:55
 **/
public interface ProcessCountCheckService {
    int deleteByPrimaryKey(@Param("ids") String[] pCountCheckIds);//通过id批量删除

    int insert(ProcessCountCheck record);//插入一条工序计数

    int insertSelective(ProcessCountCheck record);

    List<ProcessCountCheck> selectByPrimaryKey(@Param("searchValue") String pCountCheckId);//通过质检编号模糊查找

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);//通过id修改

    List<ProcessCountCheck> queryAll();//查询所有记录
}
