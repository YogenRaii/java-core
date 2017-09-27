package com.eprogrammerz.examples.cache.example.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by 542596 on 12/12/2016.
 */
public class JsonObjCacheManager {
    private static final Logger logger = LoggerFactory.getLogger(JsonObjCacheManager.class);
    private CacheManager manager;

    private Cache objectCache;

    public JsonObjCacheManager(){
        manager = CacheManager.create();

        objectCache =  manager.getCache("jsonDocCache");

        if( objectCache == null){
            objectCache = new Cache(
                    new CacheConfiguration("jsonDocCache", 1000)
                            .memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LRU)
                            .eternal(false)
                            .timeToLiveSeconds(60 * 60)
                            .timeToIdleSeconds(0)
                            .diskExpiryThreadIntervalSeconds(0)
                            .persistence(new PersistenceConfiguration().strategy(PersistenceConfiguration.Strategy.LOCALTEMPSWAP)));
            objectCache.disableDynamicFeatures();
            manager.addCache(objectCache);
        }
    }

    public List<String> getKeys() { return objectCache.getKeys();}

    public void clearCache(){
        manager.removeAllCaches();
    }

    public void putInCache(String key, Object value){
        try{
            objectCache.put(new Element(key, value));
        }catch (CacheException e){
            logger.error(String.format( "Problem occurred while putting data into cache: %s", e.getMessage()));
        }
    }

    public Object retrieveFromCache(String key){
        try {
            Element element = objectCache.get(key);
            if(element != null)
                return element.getObjectValue();
        }catch (CacheException ce){
            logger.error(String.format("Problem occurred while trying to retrieveSpecific from cache: %s", ce.getMessage()));
        }
        return null;
    }
}
