package com.xiazhe.bean.plan;

import com.xiazhe.bean.Order;

import java.util.List;

public class OrderJson {
    private int total;
    private List<Order> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Order> getRows() {
        return rows;
    }

    public void setRows(List<Order> rows) {
        this.rows = rows;
    }
}
