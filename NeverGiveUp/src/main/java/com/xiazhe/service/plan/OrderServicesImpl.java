package com.xiazhe.service.plan;

import com.github.pagehelper.PageHelper;
import com.xiazhe.bean.Order;
import com.xiazhe.bean.json.QueryJsonBean;
import com.xiazhe.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServicesImpl implements OrderServices {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public QueryJsonBean<Order> queryOrderPages(int page, int rows) {
        List<Order> orders = orderMapper.queryOrders();
        QueryJsonBean<Order> queryJsonBean = new QueryJsonBean<>();
        queryJsonBean.setTotal(orders.size());
        PageHelper pageHelper = new PageHelper();
        pageHelper.offsetPage((page-1)*rows,rows);
        orders = orderMapper.queryOrders();
        queryJsonBean.setRows(orders);
        return queryJsonBean;
    }
}
