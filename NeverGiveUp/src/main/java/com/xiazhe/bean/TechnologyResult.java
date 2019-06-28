package com.xiazhe.bean;

import java.util.List;

public class TechnologyResult {
    private int total;
    private List<TechnologyRequirement> technologyRequirements;

    public TechnologyResult() {
    }

    public TechnologyResult(int total, List<TechnologyRequirement> technologyRequirements) {
        this.total = total;
        this.technologyRequirements = technologyRequirements;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<TechnologyRequirement> getTechnologyRequirements() {
        return technologyRequirements;
    }

    public void setTechnologyRequirements(List<TechnologyRequirement> technologyRequirements) {
        this.technologyRequirements = technologyRequirements;
    }

    @Override
    public String toString() {
        return "TechnologyResult{" +
                "total=" + total +
                ", technologyRequirements=" + technologyRequirements +
                '}';
    }
}
