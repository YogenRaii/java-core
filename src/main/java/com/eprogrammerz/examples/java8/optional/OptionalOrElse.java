package com.eprogrammerz.examples.java8.optional;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


/**
 * Created by Yogen on 11/10/2016.
 * <p>
 * Optional is a container object which is used to contain not-null objects.
 * <p>
 * Optional object is used to represent null with absent value.
 * <p>
 * Has various utility to handle values as 'available' or 'not available' instead checking null values.
 */
public class OptionalOrElse {
    public static final List<String> NAMES = Arrays.asList("Rita", "Gita", "Nita", "Ritesh", "Nitesh", "Ganesh", "Yogen", "Prateema");

    public String pickLuckyNameOldWay(final List<String> names, final String startingLetter) {
        String luckyName = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                luckyName = name;
                break;
            }
        }
        return luckyName != null ? luckyName : "No lucky name found";
    }

    public String pickLuckyNameWIsPresent(final List<String> names, final String startingLetter) {
        final Optional<String> luckyName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();

        return luckyName.isPresent() ? luckyName.get() : "No lucky name found";
    }

    public String pickLuckyNameWOrElse(final List<String> names, final String startingLetter) {
        final Optional<String> luckyName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();

        return luckyName.orElse("No lucky name found");
    }

    @Test
    public void testPickLuckyNameOldWay() {
        assertEquals("Nita", pickLuckyNameOldWay(NAMES, "N"));
        assertEquals("Yogen", pickLuckyNameOldWay(NAMES, "Y"));
        assertEquals("No lucky name found", pickLuckyNameOldWay(NAMES, "Q"));
    }

    @Test
    public void testPickLuckyNameWIsPresent() {
        assertEquals("Nita", pickLuckyNameWIsPresent(NAMES, "N"));
        assertEquals("Yogen", pickLuckyNameWIsPresent(NAMES, "Y"));
        assertEquals("No lucky name found", pickLuckyNameWIsPresent(NAMES, "Q"));
    }

    @Test
    public void testPickLuckyNameWOrElse() {
        assertEquals("Nita", pickLuckyNameWOrElse(NAMES, "N"));
        assertEquals("Yogen", pickLuckyNameWOrElse(NAMES, "Y"));
        assertEquals("No lucky name found", pickLuckyNameWOrElse(NAMES, "Q"));
    }
}
