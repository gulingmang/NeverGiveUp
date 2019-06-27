package com.xiazhe.mapper;

import com.xiazhe.bean.Order;
<<<<<<< HEAD
=======

>>>>>>> 1555c8b1811b62869c37b841eab9d49f0d3ac97e

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> queryOrders();
}