package com.eprogrammerz.examples.general.enums;

import java.util.*;

public class EnumTest {
    public static void main(String[] args) {
        List<FileType> fileTypes = new ArrayList<>();
        Map<String, Object> maps = new HashMap<>();
        maps.put("fileTypes", fileTypes);

        System.out.println(maps);

        List<String> imageTypesStr = Arrays.asList(FileType.OneByOne.getValue());

        maps.put("fileTypes", imageTypesStr);

        System.out.println(maps);

    }
}
