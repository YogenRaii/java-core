package com.eprogrammerz.examples.csv;

import com.opencsv.bean.CsvBindByPosition;

/**
 * @author Yogen Rai
 */
public class SensorRecord {
    @CsvBindByPosition(position = 0)
    private String platformName;
    @CsvBindByPosition(position = 1)
    private long sendTime;
    @CsvBindByPosition(position = 2)
    private long receiveTime;
    @CsvBindByPosition(position = 3)
    private int sensorNumber;
    @CsvBindByPosition(position = 4)
    private int readingValue;

    public SensorRecord() {
    }

    public SensorRecord(String platformName, long sendTime, long receiveTime, int sensorNumber, int readingValue) {
        this.platformName = platformName;
        this.sendTime = sendTime;
        this.receiveTime = receiveTime;
        this.sensorNumber = sensorNumber;
        this.readingValue = readingValue;
    }

    public String getPlatformName() {
        return platformName;
    }

    public long getSendTime() {
        return sendTime;
    }

    public long getReceiveTime() {
        return receiveTime;
    }

    public int getSensorNumber() {
        return sensorNumber;
    }

    public int getReadingValue() {
        return readingValue;
    }

}
