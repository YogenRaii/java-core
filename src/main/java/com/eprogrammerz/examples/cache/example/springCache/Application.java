package com.eprogrammerz.examples.cache.example.springCache;

/**
 * Created by 542596 on 12/23/2016.
 */
public class Application {
    public static void main(String[] args) {
        BasicCache cache = new BasicCache("testCache");
        cache.put("key1", "Value1");

        ObjectValueWrapper value = (ObjectValueWrapper) cache.get("key1");
        System.out.println(value.get());

        final City city1 = new City("ATL","USA",12100);
        final City city2 = new City("FL","USA",12000);

        cache.put(city1.getName(), city1);
        cache.put(city2.getName(), city2);

        System.out.println(cache.size());

        ObjectValueWrapper city1Ret = (ObjectValueWrapper) cache.get("ATL");
        City cityRet = (City) city1Ret.get();
        System.out.println(cityRet);

        cityRet.setCountry("NPL");

        ObjectValueWrapper city1RetNew = (ObjectValueWrapper) cache.get("ATL");
        City cityRetNew = (City) city1RetNew.get();
        System.out.println(cityRetNew);

    }
}
