package com.eprogrammerz.examples.cache.example.ehcahce3;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 542596 on 12/24/2016.
 */
public class ObjectCacheManager {
    private final static Logger logger = LoggerFactory.getLogger(ObjectCacheManager.class);

    private Cache<String, City> objectCache;

    public ObjectCacheManager() {
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withCache("myCache",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, City.class,
                                ResourcePoolsBuilder.heap(100)).withValueSerializingCopier()
                                .build())
                .build(true);


        objectCache  = cacheManager.getCache("myCache", String.class, City.class);
    }

    /*//setting up cache
    @PostConstruct
    public void setUp(){
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
//                .with(new CacheManagerPersistenceConfiguration(new File(getCacheStoragePath(), "cachedData")))
                .withCache("jsonCache",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, JsonObjectWrapper.class,
                                ResourcePoolsBuilder.newResourcePoolsBuilder()
                                        .heap(20, EntryUnit.ENTRIES)
                                        .offheap(10, MemoryUnit.MB))
//                                        .disk(20L, MemoryUnit.MB))
                                .withExpiry(Expirations.timeToLiveExpiration(Duration.INFINITE))
                                .withValueSerializingCopier()
                                .build())
                .build(true);

        this.objectCache = cacheManager.getCache("jsonCache", String.class, JsonObjectWrapper.class);
    }*/

    public void putInCache(String key, City value){
        try{
            objectCache.put(key, value);
        }catch (Exception e){
            logger.error(String.format( "Problem occurred while putting data into cache: %s", e.getMessage()));
        }
    }

    public Object retrieveFromCache(String key){
//        System.out.println("+++++++++++");
//        System.out.println(objectCache.getKeys());
        return objectCache.get(key);
    }
}
