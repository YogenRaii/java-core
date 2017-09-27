package com.eprogrammerz.examples.cache.example.ehcache;

/**
 * Created by 542596 on 12/12/2016.
 */


public class Application {

    public static void main(String[] args) {
        JsonObjCacheManager manager = new JsonObjCacheManager();

//        manager.putInCache("key1", "Delta Airlines");
//        String storedValue = (String) manager.retrieveFromCache("key1");
//        System.out.println(storedValue);

        final City city1 = new City("ATL","USA",12100);
        final City city2 = new City("FL","USA",12000);

        //with HashMap initialization, immutable instance is created because of which exception occurs
       /* manager.putInCache(city1.getName(), new HashMap(){
            {
                put("city1", city1);
            }
        });
        manager.putInCache(city2.getName(), new HashMap(){
            {
                put("city2", city2);
            }
        });*/

        manager.putInCache(city1.getName(), city1);
        manager.putInCache(city2.getName(), city2);

        System.out.println(manager.getKeys());

        for(String key: manager.getKeys()){
            System.out.println(key + ": "+ manager.retrieveFromCache(key));
        }

//        HashMap fromCache1 = (HashMap) manager.retrieveFromCache(city1.getName());
//        HashMap fromCache = (HashMap) fromCache1.clone();
        City cityFromCache = (City) manager.retrieveFromCache(city1.getName());
        cityFromCache.setName("KTM");
        cityFromCache.setCountry("NPL");
        System.out.println(manager.getKeys());

        for(String key: manager.getKeys()){
            System.out.println(key  + ": "+ manager.retrieveFromCache(key));
        }
    }
}
