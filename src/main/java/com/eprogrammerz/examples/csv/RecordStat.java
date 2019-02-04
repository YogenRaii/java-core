package com.eprogrammerz.examples.csv;

import com.opencsv.bean.CsvBindByPosition;

/**
 * @author Yogen Rai
 */
public class RecordStat {
    @CsvBindByPosition(position = 0)
    private String platformName;
    @CsvBindByPosition(position = 1)
    private double weightedAvg;

    public RecordStat() {
    }

    public RecordStat(String platformName, double weightedAvg) {
        this.platformName = platformName;
        this.weightedAvg = weightedAvg;
    }

    public String getPlatformName() {
        return platformName;
    }

    public double getWeightedAvg() {
        return weightedAvg;
    }

}
