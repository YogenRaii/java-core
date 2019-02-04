package com.eprogrammerz.examples.csv;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Yogen Rai
 */
public class CsvUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvUtil.class);

    public static final String RESULT_FILE_NAME = "result.csv";

    public List<SensorRecord> readCsvFile(String fileName) {
        LOGGER.info("readCsvFile(): {}", fileName);
        try (Reader reader = Files.newBufferedReader(Paths.get(CsvUtil.class.getClassLoader()
                .getResource(fileName).toURI()))) {
            CsvToBean<SensorRecord> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(SensorRecord.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        } catch (URISyntaxException | IOException e) {
            LOGGER.warn("Error while reading csv . . .", e);
        }
        return null;
    }

    public void writeStatsToCsv(List<RecordStat> recordStats) {
        try (Writer writer = Files.newBufferedWriter(Paths.get(RESULT_FILE_NAME))) {
            StatefulBeanToCsv<RecordStat> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            beanToCsv.write(recordStats);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
            LOGGER.warn("Error while writing csv . . .", e);
        }
    }
}
