package com.xiazhe.mapper;

import com.xiazhe.bean.Order;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> queryOrders();

    List<Order> searchOrders(@Param("value") String value, @Param("op") String op);


    List<Order> getlist();
}