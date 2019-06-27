package com.xiazhe.service.plan;

import com.xiazhe.bean.Order;
import com.xiazhe.bean.plan.OrderJson;
import com.xiazhe.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServicesImpl implements OrderServices {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public OrderJson queryOrders() {
        OrderJson orderJson = new OrderJson();
        List<Order> orders = orderMapper.queryOrders();
        orderJson.setRows(orders);
        orderJson.setTotal(orders.size());
        return orderJson;
    }
}
