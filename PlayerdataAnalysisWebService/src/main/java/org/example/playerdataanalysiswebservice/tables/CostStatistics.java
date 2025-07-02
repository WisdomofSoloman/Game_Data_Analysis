package org.example.playerdataanalysiswebservice.tables;

public class CostStatistics {
    private int highCostCount;  // 大于30
    private int mediumCostCount; // 0-30
    private int zeroCostCount;  // 等于0

    // getter/setter方法

    public int getHighCostCount() {
        return highCostCount;
    }

    public void setHighCostCount(int highCostCount) {
        this.highCostCount = highCostCount;
    }

    public int getMediumCostCount() {
        return mediumCostCount;
    }

    public void setMediumCostCount(int mediumCostCount) {
        this.mediumCostCount = mediumCostCount;
    }

    public int getZeroCostCount() {
        return zeroCostCount;
    }

    public void setZeroCostCount(int zeroCostCount) {
        this.zeroCostCount = zeroCostCount;
    }
}
