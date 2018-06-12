package com.eprogrammerz.examples.java8.optional;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class OptionalOrElseThrow {
    public static final List<String> NAMES = Arrays.asList("Rita", "Gita", "Nita", "Ritesh", "Nitesh", "Ganesh", "Yogen", "Prateema");

    public String pickLuckyNameOldWay(final List<String> names, final String startingLetter) {
        String luckyName = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                luckyName = name;
                break;
            }
        }
        if (luckyName == null) {
            throw new NotFoundException("There is no name starting with letter.");
        }
        return luckyName;
    }

    public String pickLuckyNameWOrElse(final List<String> names, final String startingLetter) {
        final Optional<String> luckyName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();

        return luckyName.orElseThrow(() -> new NotFoundException("There is no name starting with letter."));
    }

    @Test
    public void testPickLuckyNameOldWay() {
        assertEquals("Nita", pickLuckyNameOldWay(NAMES, "N"));
        assertEquals("Yogen", pickLuckyNameOldWay(NAMES, "Y"));
        assertEquals("No lucky name found", pickLuckyNameOldWay(NAMES, "Q"));
    }

    @Test
    public void testPickLuckyNameWOrElseOk() {
        assertEquals("Nita", pickLuckyNameWOrElse(NAMES, "N"));
        assertEquals("Yogen", pickLuckyNameWOrElse(NAMES, "Y"));
    }

    @Test(expected = NotFoundException.class)
    public void testPickLuckyNameWOrElseException() {
        pickLuckyNameWOrElse(NAMES, "Q");
        pickLuckyNameWOrElse(NAMES, "1");
    }
}
