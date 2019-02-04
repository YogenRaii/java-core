package com.eprogrammerz.examples.csv;

import java.util.List;
import java.util.stream.Collectors;

public class CsvReaderApplication {

    public static void main(String[] args) {
        processSensorData("input.csv");
    }

    public static void processSensorData(String fileName) {
        final CsvUtil csvUtil = new CsvUtil();
        // reading csv
        List<SensorRecord> sensorRecords = csvUtil.readCsvFile(fileName);

        if (sensorRecords == null) return;

        List<RecordStat> recordStats = sensorRecords
                .stream()
                .collect(Collectors.groupingBy(SensorRecord::getPlatformName, Collectors.averagingInt(SensorRecord::getReadingValue)))
                .entrySet().stream().map(e -> new RecordStat(e.getKey(), e.getValue())).collect(Collectors.toList());

        // write to csv
        csvUtil.writeStatsToCsv(recordStats);
    }
}
