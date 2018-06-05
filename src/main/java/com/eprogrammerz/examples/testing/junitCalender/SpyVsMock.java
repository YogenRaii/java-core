package com.eprogrammerz.examples.testing.junitCalender;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yogen Rai
 */
public class SpyVsMock {
    @Test
    public void testSpy() {
        final List<String> names = new ArrayList<>();

        // spy wraps and give new instance from existing instance
        // can be used for partial mocking
        final List<String> namesSpy = Mockito.spy(names);

        namesSpy.add("yogen");
        namesSpy.add("pratima");

        Mockito.verify(namesSpy).add("yogen");

        // spy calls the real implementation and produces side effect
        Assert.assertEquals(2, namesSpy.size());
    }

    @Test
    public void testMock() {
        // mock gives new shell from the class
        List<String> namesMock = Mockito.mock(ArrayList.class);

        namesMock.add("Yogen");
        namesMock.add("Pratima");

        Mockito.verify(namesMock).add("Yogen");

        // mock actually doesn't call the real method, so doesn't produce side effect
        Assert.assertEquals(0, namesMock.size());
    }
}
