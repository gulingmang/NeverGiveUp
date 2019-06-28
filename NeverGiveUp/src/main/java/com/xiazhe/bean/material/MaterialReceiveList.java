package com.xiazhe.bean.material;

import java.util.List;

public class MaterialReceiveList {
    int total;
    List<MaterialReceive> rows;

    public MaterialReceiveList() {
    }

    public MaterialReceiveList(int total, List<MaterialReceive> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MaterialReceive> getRows() {
        return rows;
    }

    public void setRows(List<MaterialReceive> rows) {
        this.rows = rows;
    }
}
