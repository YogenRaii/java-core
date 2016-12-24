package com.eprogrammerz.examples.cache.example.jcs;

import org.apache.commons.jcs.engine.control.CompositeCacheManager;

import java.io.*;
import java.util.Properties;

/**
 * Created by 542596 on 12/9/2016.
 */
public class Application {
    public static void main(String[] args) throws IOException {
        CompositeCacheManager ccm = CompositeCacheManager.getUnconfiguredInstance();
        Properties properties = new Properties();
        File file = new File("C:/Users/542596/failfast/examples/core/src/main/java/com/delta/cache/example/jcs/cache.ccf");
        InputStream stream = null;
        try {
            stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        properties.load(stream);

        ccm.configure(properties);
        CachingTest cachingTest = new CachingTest();
        cachingTest.testCache();
    }
}
