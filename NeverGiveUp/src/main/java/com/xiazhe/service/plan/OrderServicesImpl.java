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
        pageHelper.offsetPage((page - 1) * rows, rows);
        orders = orderMapper.queryOrders();
        queryJsonBean.setRows(orders);
        return queryJsonBean;
    }

    @Override
    public int insertNewOrder(Order order) {
        int insert = orderMapper.insert(order);
        return insert;
    }

    @Override
    public int deleteOrders(String[] ids) {
        // 删除的时候记录删除的个数
        int count = 0;
        for (int i = 0; i < ids.length; i++) {
            count += orderMapper.deleteByPrimaryKey(ids[i]);
        }
        if (count > 0) {
            return count;
        } else {
            return 0;
        }
    }

    @Override
    public int updateOrder(Order order) {
        int i = orderMapper.updateByPrimaryKey(order);
        if (i > 0) {
            return i;
        } else {
            return 0;
        }
    }

    @Override
    public QueryJsonBean<Order> searchOrders(String value, String op, int page, int rows) {
        QueryJsonBean<Order> queryJsonBean = new QueryJsonBean<>();
        List<Order> orders = orderMapper.searchOrders(value, op);
        queryJsonBean.setTotal(orders.size());
        PageHelper pageHelper = new PageHelper();
        pageHelper.offsetPage((page - 1) * rows, rows);
        orders = orderMapper.searchOrders(value, op);
        queryJsonBean.setRows(orders);
        return queryJsonBean;
    }

    public List<Order> getlist() {
        return orderMapper.queryOrders();
    }
}
