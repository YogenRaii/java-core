package com.eprogrammerz.examples.ds.cache;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LRUCacheTest {
    @Test
    public void testLRUCache() {
        LRUCache<String, String> cache = new LRUCache<>(3);
        cache.put("Yogen", "rai1");
        cache.put("Pratima", "rai2");
        cache.put("Yogesh", "rai3");

        assertEquals("rai1", (cache.get("Yogen"))); // ["Yogesh", "Pratima", "Yogen"]
        assertEquals("rai2", cache.get("Pratima")); // ["Pratima", "Yogesh", "Yogen"]

        cache.put("Srijana", "khaling");
        cache.put("another", "another");
        assertNull(cache.get("Yogen"));
        assertNull(cache.get("Yogesh"));
        assertEquals("rai2", cache.get("Pratima"));
        assertEquals("khaling", cache.get("Srijana"));
        assertEquals("another", cache.get("another")); // ["another", "srijana", "Pratima"]
    }
}
