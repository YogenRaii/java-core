package com.eprogrammerz.examples.general.hashGenerator;

import com.google.common.io.ByteStreams;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import static org.junit.Assert.assertEquals;

@Slf4j
@RunWith(JUnit4.class)
public class HashGenerator {
    public static final String HASH_ALGORITHM = "MD5";

    @Test
    public void testHashGenerators() throws IOException, NoSuchAlgorithmException {
        File input = new File("/Users/yrai/Downloads/E.tif");
//        ClassLoader classLoader = getClass().getClassLoader();
//        File input = new File(classLoader.getResource("random-pic.jpg").getFile());

        long startTime = System.currentTimeMillis();
        String handBufHashValue = getImageHashValue(input);
        long completeTime = System.currentTimeMillis();
        log.info("Custom buffer: {} ns", completeTime - startTime);

        startTime = System.currentTimeMillis();
        String hashValueWithCopy = getImageHashValueWithCopy(input);
        completeTime = System.currentTimeMillis();
        log.info("Guava: {} ns", completeTime - startTime);

        assertEquals(handBufHashValue, hashValueWithCopy);

//        getHashWithByteBuffer(input);
    }

    public static String getImageHashValue(File input) throws IOException, NoSuchAlgorithmException {
        InputStream is = new FileInputStream(input);

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            log.error("Invalid hash algorithm: {}", HASH_ALGORITHM);
        }

        final byte[] buffer = new byte[1024];
        for (int read = 0; (read = is.read(buffer)) != -1;) {
            messageDigest.update(buffer, 0, read);
        }
        // Convert the byte to hex format
        try (Formatter formatter = new Formatter()) {
            for (final byte b : messageDigest.digest()) {
                formatter.format("%02x", b);
            }
            return formatter.toString();
        }
    }

    public static String getImageHashValueWithCopy(File input) throws IOException, NoSuchAlgorithmException {
        InputStream is = new FileInputStream(input);

        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            log.error("Invalid hash algorithm: {}", HASH_ALGORITHM);
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteStreams.copy(is, out);

        byte[] data = out.toByteArray();

        messageDigest.update(data);
        // Convert the byte to hex format
        try (Formatter formatter = new Formatter()) {
            for (final byte b : messageDigest.digest()) {
                formatter.format("%02x", b);
            }
            return formatter.toString();
        }
    }

    public static String getHashWithByteBuffer(File input) throws IOException, NoSuchAlgorithmException {
        BufferedImage buffImg = ImageIO.read(input);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(buffImg, "tif", outputStream);
        byte[] data = outputStream.toByteArray();

        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
        md.update(data);
        byte[] hash = md.digest();

        String hashValue = null;

        try (Formatter formatter = new Formatter()) {
            for (final byte b : hash) {
                formatter.format("%02x", b);
            }
            hashValue = formatter.toString();
        }
        return hashValue;
    }
}
