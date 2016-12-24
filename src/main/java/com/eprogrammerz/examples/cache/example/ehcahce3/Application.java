package com.eprogrammerz.examples.cache.example.ehcahce3;

/**
 * Created by 542596 on 12/23/2016.
 */
public class Application {
    public static void main(String[] args) {
        ObjectCacheManager manager = new ObjectCacheManager();

        final City city1 = new City("ATL","USA",12100);
        final City city2 = new City("FL","USA",12000);

        manager.putInCache(city1.getName(), city1);
        manager.putInCache(city2.getName(), city2);

//        System.out.println(cache.size());

        City cityFromCache = (City) manager.retrieveFromCache(city1.getName());
        System.out.println(cityFromCache);

        cityFromCache.setName("KTM");
        cityFromCache.setCountry("NPL");
        System.out.println(cityFromCache);

        City newCityFromCache = (City) manager.retrieveFromCache(city1.getName());
        System.out.println(newCityFromCache);
    }
}
