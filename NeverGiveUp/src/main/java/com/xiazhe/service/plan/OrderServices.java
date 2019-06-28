package com.xiazhe.service.plan;

import com.xiazhe.bean.Order;
import com.xiazhe.bean.json.QueryJsonBean;

public interface OrderServices {
    QueryJsonBean<Order> queryOrderPages(int page, int rows);

    int insertNewOrder(Order order);

    int deleteOrders(String[] ids);

    int updateOrder(Order order);

    QueryJsonBean<Order> searchOrders(String value,String op, int page, int rows);
}
