package com.xiazhe.bean.plan;

import com.xiazhe.bean.Order;
import com.xiazhe.bean.Technology;

public class PlanManufactureBean {
  private String manufactureSn ;
  private int launchQuantity ;
  private String beginDate ;
  private String endDate ;
  private Order cOrder;
  private Technology technology;

    public PlanManufactureBean() {
    }

    public PlanManufactureBean(String manufactureSn, int launchQuantity, String beginDate, String endDate, Order cOrder, Technology technology) {
        this.manufactureSn = manufactureSn;
        this.launchQuantity = launchQuantity;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.cOrder = cOrder;
        this.technology = technology;
    }

    public String getManufactureSn() {
        return manufactureSn;
    }

    public void setManufactureSn(String manufactureSn) {
        this.manufactureSn = manufactureSn;
    }

    public int getLaunchQuantity() {
        return launchQuantity;
    }

    public void setLaunchQuantity(int launchQuantity) {
        this.launchQuantity = launchQuantity;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Order getcOrder() {
        return cOrder;
    }

    public void setcOrder(Order cOrder) {
        this.cOrder = cOrder;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }
}
