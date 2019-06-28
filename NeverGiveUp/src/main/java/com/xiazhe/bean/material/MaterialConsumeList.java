package com.xiazhe.bean.material;

import java.util.List;

public class MaterialConsumeList {
    int total;
    List<MaterialConsume> rows;

    public MaterialConsumeList() {
    }

    public MaterialConsumeList(int total, List<MaterialConsume> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MaterialConsume> getRows() {
        return rows;
    }

    public void setRows(List<MaterialConsume> rows) {
        this.rows = rows;
    }
}
