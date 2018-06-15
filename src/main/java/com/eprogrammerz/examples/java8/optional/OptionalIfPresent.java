package com.eprogrammerz.examples.java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Yogen Rai
 *
 * Proper usage of Optional
 *
 * https://www.nurkiewicz.com/2013/08/optional-in-java-8-cheat-sheet.html
 */
public class OptionalIfPresent {
    public static final List<String> NAMES = Arrays.asList("Rita", "Gita", "Nita", "Ritesh", "Nitesh", "Ganesh", "Yogen", "Prateema");

    public static void pickLuckyNameOldWay(final List<String> names, final String startingLetter) {
        String luckyName = null;
        for (String name : names) {
            if (name.startsWith(startingLetter)) {
                luckyName = name;
                break;
            }
        }
        if (luckyName != null) {
            postMessage(luckyName);
        }
    }

    public static void pickLuckyNameNewWay(final List<String> names, final String startingLetter) {
        final Optional<String> luckyName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
        luckyName.ifPresent(OptionalIfPresent::postMessage);
    }

    public static void postMessage(final String winnerName) {
        System.out.println(String.format("Congratulations, %s!", winnerName));
    }

    public static void main(String[] args) {
        pickLuckyNameOldWay(NAMES, "Y");
        pickLuckyNameNewWay(NAMES, "Y");
    }
}
