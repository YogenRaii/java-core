package com.eprogrammerz.examples.cache.example.springCache;

import org.springframework.cache.Cache;

import java.io.Serializable;

public class ObjectValueWrapper implements Cache.ValueWrapper,Serializable
{
	private static final long serialVersionUID = -8867908696247169011L;
	public final Long timestamp = System.currentTimeMillis();
	public Long requests = 0L;
	public final Object value;
	public ObjectValueWrapper(Object value)
	{
		this.value = value;
	}
	@Override
	public Object get()
	{
		requests++;
		return value;
	}
}
