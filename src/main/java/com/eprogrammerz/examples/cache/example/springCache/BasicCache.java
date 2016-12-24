package com.eprogrammerz.examples.cache.example.springCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

public class BasicCache implements Cache {
	
	private Map<Object,ObjectValueWrapper> cacheMap = new Hashtable<Object,ObjectValueWrapper>();
	private final LinkedBlockingQueue<Object> order;
	private final String name;
	private final long intervalTime;
	private final int staleTime;
	private final int maxCache;
	private Logger logger = LoggerFactory.getLogger(BasicCache.class);

	public BasicCache(String name)
	{
		this.name = name;
		Properties props = new Properties();
		loadDefaults(props);
		try
		{
			props.load(this.getClass().getResourceAsStream("/resources/cache.properties"));
		}
		catch(Exception e)
		{
			logger.warn("can not find properties file in the cache.properties classpath.");
		}
		this.maxCache = Integer.parseInt(props.getProperty(this.name + ".maxCacheSize", "100"));
		this.staleTime = Integer.parseInt(props.getProperty(this.name + ".staleTime", "0"));
		this.intervalTime = Long.parseLong(props.getProperty(this.name + ".intervalTime", "10"));
		order = new LinkedBlockingQueue<Object>(this.maxCache);
		Timer watchTimer = new Timer();
		watchTimer.schedule(new CacheWatcher(), intervalTime *1000, intervalTime *1000);
	}
	
	@Override
	public void evict(Object object)
	{
		synchronized(cacheMap)
		{
			cacheMap.remove(object);
		}
	}

	@Override
	public ValueWrapper get(Object object)
	{
		ObjectValueWrapper value = cacheMap.get(object);
		if(value == null || staleTime == 0 || ((System.currentTimeMillis() - value.timestamp) < staleTime))
		{
			return value;
		}
		else
		{
			evict(object);
			return null;
		}
	}

	@Override
	public <T> T get(Object o, Class<T> aClass) {
		return null;
	}

	@Override
	public <T> T get(Object o, Callable<T> callable) {
		return null;
	}

	@Override
	public Object getNativeCache()
	{
		return this;
	}

	@Override
	public void put(Object key, Object value)
	{
		// evict oldest slot if key is new and queue cannot accept it.
		if(order.contains(key) || order.offer(key))
		{
			synchronized(cacheMap)
			{
				cacheMap.put(key, new ObjectValueWrapper(value));
			}
			return;
		}
		else
		{
			Object o = order.poll();
			if(o != null)
			{
				evict(o);
			}
		}
		put(key,value);
	}

	@Override
	public ValueWrapper putIfAbsent(Object o, Object o1) {
		return null;
	}

	@Override
	public void clear()
	{
		synchronized(cacheMap)
		{
			this.cacheMap.clear();	
		}
	}

	@Override
	public String getName()
	{
		return this.name;
	}
	
	public int size()
	{
		return this.cacheMap.size();
	}
	
	private Properties loadDefaults(Properties props)
	{
		props.setProperty(this.name + ".maxCacheSize", "100");
		props.setProperty(this.name + ".staleTime", "0");
		props.setProperty(this.name + ".maxHitCount", "0");
		props.setProperty(this.name + ".intervalTime", "30");
		return props;
	}
	
	class CacheWatcher extends TimerTask
	{

		@Override
		public void run()
		{
			ArrayList<Object> remove = new ArrayList<Object>();
			Set<Object> keys = cacheMap.keySet();
			for(Object key: keys)
			{
				ObjectValueWrapper value = (ObjectValueWrapper)cacheMap.get(key);
				if((System.currentTimeMillis() - value.timestamp) > staleTime)
				{
					remove.add(key);
				}
			}
			for(Object key:remove)
			{
				evict(key);
			}
		}
		
	}
}