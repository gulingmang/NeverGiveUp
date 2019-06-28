package com.xiazhe.bean.material;

import java.util.List;

public class MaterialList {
    int total;
    List<Material> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Material> getRows() {
        return rows;
    }

    public void setRows(List<Material> rows) {
        this.rows = rows;
    }

    public MaterialList() {
    }

    public MaterialList(int total, List<Material> rows) {
        this.total = total;
        this.rows = rows;
    }
}
