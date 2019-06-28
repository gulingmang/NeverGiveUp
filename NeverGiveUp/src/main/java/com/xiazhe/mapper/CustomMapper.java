package com.xiazhe.mapper;

import com.xiazhe.bean.Custom;
import com.xiazhe.bean.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomMapper {
    int deleteByPrimaryKey(String customId);

    int insert(Custom record);

    int insertSelective(Custom record);

    Custom selectByPrimaryKey(String customId);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    List<Custom> queryCustoms();

    List<Custom> searchCustoms(@Param("value") String value, @Param("op") String op);
}