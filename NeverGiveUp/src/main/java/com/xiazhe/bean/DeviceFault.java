package com.xiazhe.bean;

import java.awt.datatransfer.StringSelection;
import java.util.Date;
import java.util.Objects;

public class DeviceFault {
    private String deviceId;
    private String deviceName;
    private String deviceFaultId;
    private String deviceFaultCause;
    private String deviceFaultDetail;
    private Date deviceFaultDate;
    private String deviceFaultMaintenance;

    public DeviceFault() {
    }

    public DeviceFault(String deviceId, String deviceName, String deviceFaultId, String deviceFaultCause, String deviceFaultDetail, Date deviceFaultDate, String deviceFaultMaintenance) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.deviceFaultId = deviceFaultId;
        this.deviceFaultCause = deviceFaultCause;
        this.deviceFaultDetail = deviceFaultDetail;
        this.deviceFaultDate = deviceFaultDate;
        this.deviceFaultMaintenance = deviceFaultMaintenance;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceFaultId() {
        return deviceFaultId;
    }

    public void setDeviceFaultId(String deviceFaultId) {
        this.deviceFaultId = deviceFaultId;
    }

    public String getDeviceFaultCause() {
        return deviceFaultCause;
    }

    public void setDeviceFaultCause(String deviceFaultCause) {
        this.deviceFaultCause = deviceFaultCause;
    }

    public String getDeviceFaultDetail() {
        return deviceFaultDetail;
    }

    public void setDeviceFaultDetail(String deviceFaultDetail) {
        this.deviceFaultDetail = deviceFaultDetail;
    }

    public Date getDeviceFaultDate() {
        return deviceFaultDate;
    }

    public void setDeviceFaultDate(Date deviceFaultDate) {
        this.deviceFaultDate = deviceFaultDate;
    }

    public String getDeviceFaultMaintenance() {
        return deviceFaultMaintenance;
    }

    public void setDeviceFaultMaintenance(String deviceFaultMaintenance) {
        this.deviceFaultMaintenance = deviceFaultMaintenance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceFault that = (DeviceFault) o;
        return Objects.equals(deviceFaultId, that.deviceFaultId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceFaultId);
    }

    @Override
    public String toString() {
        return "DeviceFault{" +
                "deviceId='" + deviceId + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceFaultId='" + deviceFaultId + '\'' +
                ", deviceFaultCause='" + deviceFaultCause + '\'' +
                ", deviceFaultDetail='" + deviceFaultDetail + '\'' +
                ", deviceFaultDate=" + deviceFaultDate +
                ", deviceFaultMaintenance='" + deviceFaultMaintenance + '\'' +
                '}';
    }
}
