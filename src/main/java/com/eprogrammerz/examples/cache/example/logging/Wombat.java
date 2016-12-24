package com.eprogrammerz.examples.cache.example.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 542596 on 12/22/2016.
 */
public class Wombat {
    final static Logger logger = LoggerFactory.getLogger(Wombat.class);

    public static void main(String[] args) {
        args = new String[]{"12"};
        DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        logger.info("Temperature set to {} on {}", args[0], formatter.format(new Date()));
    }
}
