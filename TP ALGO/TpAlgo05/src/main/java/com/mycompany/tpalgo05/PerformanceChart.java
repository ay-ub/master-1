package com.mycompany.tpalgo05;


public class PerformanceChart {
    private final String fileName;
    private final long naiveTime;
    private final long rkTime;
    private final long kmpTime;
    private final long bmTime;

    public PerformanceChart(String fileName, long naiveTime, long rkTime, long kmpTime, long bmTime) {
        this.fileName = fileName;
        this.naiveTime = naiveTime;
        this.rkTime = rkTime;
        this.kmpTime = kmpTime;
        this.bmTime = bmTime;
    }

    public String getFileName() {
        return fileName;
    }

    public long getNaiveTime() {
        return naiveTime;
    }

    public long getRkTime() {
        return rkTime;
    }

    public long getKmpTime() {
        return kmpTime;
    }

    public long getBmTime() {
        return bmTime;
    }
}
