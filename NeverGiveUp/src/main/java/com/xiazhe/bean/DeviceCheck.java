package com.xiazhe.bean;

import java.util.Date;

public class DeviceCheck {
    private String deviceCheckId;
    private String deviceId;
    private String deviceCheckEmpId;
    private Date deviceCheckDate;
    private String deviceCheckResult;
    private String deviceCheckFaultId;
    private String deviceName;
    private String deviceCheckEmp;

    public DeviceCheck() {
    }

    public DeviceCheck(String deviceCheckId, String deviceId, String deviceCheckEmpId, Date deviceCheckDate, String deviceCheckResult, String deviceCheckFaultId, String deviceName, String deviceCheckEmp) {
        this.deviceCheckId = deviceCheckId;
        this.deviceId = deviceId;
        this.deviceCheckEmpId = deviceCheckEmpId;
        this.deviceCheckDate = deviceCheckDate;
        this.deviceCheckResult = deviceCheckResult;
        this.deviceCheckFaultId = deviceCheckFaultId;
        this.deviceName = deviceName;
        this.deviceCheckEmp = deviceCheckEmp;
    }

    public String getDeviceCheckId() {
        return deviceCheckId;
    }

    public void setDeviceCheckId(String deviceCheckId) {
        this.deviceCheckId = deviceCheckId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceCheckEmpId() {
        return deviceCheckEmpId;
    }

    public void setDeviceCheckEmpId(String deviceCheckEmpId) {
        this.deviceCheckEmpId = deviceCheckEmpId;
    }

    public Date getDeviceCheckDate() {
        return deviceCheckDate;
    }

    public void setDeviceCheckDate(Date deviceCheckDate) {
        this.deviceCheckDate = deviceCheckDate;
    }

    public String getDeviceCheckResult() {
        return deviceCheckResult;
    }

    public void setDeviceCheckResult(String deviceCheckResult) {
        this.deviceCheckResult = deviceCheckResult;
    }

    public String getDeviceCheckFaultId() {
        return deviceCheckFaultId;
    }

    public void setDeviceCheckFaultId(String deviceCheckFaultId) {
        this.deviceCheckFaultId = deviceCheckFaultId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceCheckEmp() {
        return deviceCheckEmp;
    }

    public void setDeviceCheckEmp(String deviceCheckEmp) {
        this.deviceCheckEmp = deviceCheckEmp;
    }

    @Override
    public String toString() {
        return "DeviceCheck{" +
                "deviceCheckId='" + deviceCheckId + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceCheckEmpId='" + deviceCheckEmpId + '\'' +
                ", deviceCheckDate=" + deviceCheckDate +
                ", deviceCheckResult='" + deviceCheckResult + '\'' +
                ", deviceCheckFaultId='" + deviceCheckFaultId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceCheckEmp='" + deviceCheckEmp + '\'' +
                '}';
    }
}
