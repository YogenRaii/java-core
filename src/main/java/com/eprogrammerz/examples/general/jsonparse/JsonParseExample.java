package com.eprogrammerz.examples.general.jsonparse;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by 542596 on 1/23/2017.
 */
public class JsonParseExample {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        String s = "[{\"6\":7},{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";

        Object obj = null;
        try {
            obj = parser.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONArray array = (JSONArray)obj;
        System.out.println(obj);
        System.out.println(array);
    }
}
