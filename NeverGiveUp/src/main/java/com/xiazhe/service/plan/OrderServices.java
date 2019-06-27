package com.xiazhe.service.plan;

import com.xiazhe.bean.Order;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.bean.plan.OrderJson;

public interface OrderServices {
    QueryJsonBean<Order> queryOrders(int page, int rows);
}
