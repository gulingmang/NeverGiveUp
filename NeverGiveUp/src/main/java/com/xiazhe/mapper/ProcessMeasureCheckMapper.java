package com.xiazhe.mapper;

import com.xiazhe.bean.ProcessMeasureCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProcessMeasureCheckMapper {
    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);

    List<ProcessMeasureCheck> getlist();

    int deleteByIds(@Param("ids") String[] ids);

    List<ProcessMeasureCheck>  serchById(@Param("searchValue")String searchValue);

    int updatenote(@Param("pMeasureCheckId")String pMeasureCheckId, @Param("note") String note);
}