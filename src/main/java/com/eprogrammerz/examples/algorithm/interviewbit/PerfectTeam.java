package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Find how many perfect teams can be formed consisting of each of physics (p), chemistry (c), math (m), zoology (z) and botany (b)
 */

public class PerfectTeam {
    static int differentTeams(String skills) {
        Map<Character, Integer> skillCount = new HashMap<>();

        for (Character skill: skills.toCharArray()) {
            if (skillCount.containsKey(skill)) {
                skillCount.put(skill, skillCount.get(skill) + 1);
            } else {
                skillCount.put(skill, 1);
            }
        }

        // if there is no 5 skills, then no groups can be formed
        if (skillCount.size() < 5) return 0;

        int maxPossibleGroup = Integer.MAX_VALUE;

        for (int count: skillCount.values()) {

            if (count < maxPossibleGroup) {
                maxPossibleGroup = count;
            }
        }
        return maxPossibleGroup == Integer.MAX_VALUE ? 0 : maxPossibleGroup;
    }

    @Test
    public void testPerfectTeams() {
        assertEquals(0, differentTeams("pppccmm"));
        assertEquals(1, differentTeams("pppccmmbz"));
        assertEquals(2, differentTeams("pcmbzzbmcp"));
    }
}
