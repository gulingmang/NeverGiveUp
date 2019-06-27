package com.xiazhe.service.plan;

import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.Order;
import com.xiazhe.bean.json.QueryJsonBean;
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
    public QueryJsonBean<Order> queryOrders(int page, int rows) {
        QueryJsonBean<Order> queryJsonBean = new QueryJsonBean<>();
        List<Order> orders = orderMapper.queryOrders();
        queryJsonBean.setRows(orders);
        queryJsonBean.setTotal(orders.size());
        return queryJsonBean;
    }
}
