package com.xiazhe.mapper;

import com.xiazhe.bean.FinalCountCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FinalCountCheckMapper {
    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);

    List<FinalCountCheck> getlist();

    int deleteByIds(@Param("ids")String[] ids);

    List<FinalCountCheck> getlistByOrderId( String searchValue);

    List<FinalCountCheck> getlistByFcountCkeckId(String searchValue);

    int updateNote(@Param("fCountCheckId") String fCountCheckId, @Param("note") String note);
}