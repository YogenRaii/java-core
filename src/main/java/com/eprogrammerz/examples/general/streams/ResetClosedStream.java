package com.eprogrammerz.examples.general.streams;

import com.google.common.io.ByteStreams;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Yogen Rai
 */
public class ResetClosedStream {
    public static void main(String[] args) throws IOException {
        byte[] nums = {1,2,3};
        final InputStream bis = new ByteArrayInputStream("yogen".getBytes());

        streamResetter(bis);
//        bis.close();

        bis.reset();

        byte[] reads = ByteStreams.toByteArray(bis);
        System.out.println(new String(reads));
    }

    private static void streamResetter(InputStream is) {
        byte[] reads = new byte[0];
        try {
            reads = ByteStreams.toByteArray(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(new String(reads));

    }
}
