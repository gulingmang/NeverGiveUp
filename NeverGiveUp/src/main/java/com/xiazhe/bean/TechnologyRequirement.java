package com.xiazhe.bean;

import java.util.Date;

public class TechnologyRequirement {
    private String technologyRequirementId;

    private String technologyId;

    private String requirement;

    private Date addTime;

    private Date reviseTime;

    public TechnologyRequirement() {
    }

    public TechnologyRequirement(String technologyRequirementId, String technologyId, String requirement, Date addTime, Date reviseTime) {

        this.technologyRequirementId = technologyRequirementId;
        this.technologyId = technologyId;
        this.requirement = requirement;
        this.addTime = addTime;
        this.reviseTime = reviseTime;
    }

    @Override
    public String toString() {
        return "TechnologyRequirement{" +
                "technologyRequirementId='" + technologyRequirementId + '\'' +
                ", technologyId='" + technologyId + '\'' +
                ", requirement='" + requirement + '\'' +
                ", addTime=" + addTime +
                ", reviseTime=" + reviseTime +
                '}';
    }

    public String getTechnologyRequirementId() {
        return technologyRequirementId;
    }

    public void setTechnologyRequirementId(String technologyRequirementId) {
        this.technologyRequirementId = technologyRequirementId == null ? null : technologyRequirementId.trim();
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId == null ? null : technologyId.trim();
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement == null ? null : requirement.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getReviseTime() {
        return reviseTime;
    }

    public void setReviseTime(Date reviseTime) {
        this.reviseTime = reviseTime;
    }
}