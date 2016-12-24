package com.eprogrammerz.examples.cache.example.logging;

/**
 * Created by 542596 on 12/22/2016.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        logger.info("Hello World");
    }
}