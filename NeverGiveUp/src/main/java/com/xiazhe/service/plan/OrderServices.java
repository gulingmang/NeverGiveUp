package com.xiazhe.service.plan;

import com.xiazhe.bean.Order;
import com.xiazhe.bean.json.QueryJsonBean;

public interface OrderServices {
    QueryJsonBean<Order> queryOrderPages(int page, int rows);
}
