package com.xiazhe.bean;

import java.util.Date;

public class DeviceType {
    String device_type_id;
    String device_type_name;
    String device_type_model;
    String device_type_spec;
    String device_type_supplier;
    String device_type_producer;
    int device_type_quantity;
    Date device_type_warranty;

    public DeviceType() {
    }

    public DeviceType(String device_type_id, String device_type_name, String device_type_model, String device_type_spec, String device_type_supplier, String device_type_producer, int device_type_quantity, Date device_type_warranty) {
        this.device_type_id = device_type_id;
        this.device_type_name = device_type_name;
        this.device_type_model = device_type_model;
        this.device_type_spec = device_type_spec;
        this.device_type_supplier = device_type_supplier;
        this.device_type_producer = device_type_producer;
        this.device_type_quantity = device_type_quantity;
        this.device_type_warranty = device_type_warranty;
    }

    public String getDevice_type_id() {
        return device_type_id;
    }

    public void setDevice_type_id(String device_type_id) {
        this.device_type_id = device_type_id;
    }

    public String getDevice_type_name() {
        return device_type_name;
    }

    public void setDevice_type_name(String device_type_name) {
        this.device_type_name = device_type_name;
    }

    public String getDevice_type_model() {
        return device_type_model;
    }

    public void setDevice_type_model(String device_type_model) {
        this.device_type_model = device_type_model;
    }

    public String getDevice_type_spec() {
        return device_type_spec;
    }

    public void setDevice_type_spec(String device_type_spec) {
        this.device_type_spec = device_type_spec;
    }

    public String getDevice_type_supplier() {
        return device_type_supplier;
    }

    public void setDevice_type_supplier(String device_type_supplier) {
        this.device_type_supplier = device_type_supplier;
    }

    public String getDevice_type_producer() {
        return device_type_producer;
    }

    public void setDevice_type_producer(String device_type_producer) {
        this.device_type_producer = device_type_producer;
    }

    public int getDevice_type_quantity() {
        return device_type_quantity;
    }

    public void setDevice_type_quantity(int device_type_quantity) {
        this.device_type_quantity = device_type_quantity;
    }

    public Date getDevice_type_warranty() {
        return device_type_warranty;
    }

    public void setDevice_type_warranty(Date device_type_warranty) {
        this.device_type_warranty = device_type_warranty;
    }

    @Override
    public String toString() {
        return "DeviceType{" +
                "device_type_id='" + device_type_id + '\'' +
                ", device_type_name='" + device_type_name + '\'' +
                ", device_type_model='" + device_type_model + '\'' +
                ", device_type_spec='" + device_type_spec + '\'' +
                ", device_type_supplier='" + device_type_supplier + '\'' +
                ", device_type_producer='" + device_type_producer + '\'' +
                ", device_type_quantity=" + device_type_quantity +
                ", device_type_warranty=" + device_type_warranty +
                '}';
    }
}
