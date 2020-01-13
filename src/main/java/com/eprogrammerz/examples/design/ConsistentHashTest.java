package com.eprogrammerz.examples.design;

import org.junit.Test;

import java.util.*;
import java.util.zip.CRC32;

public class ConsistentHashTest {
    @Test
    public void test() {
        List<Server> servers = Arrays.asList(new Server("10.0.0.1"), new Server("10.0.0.2"));
        ConsistentHash consistentHash = new ConsistentHash(5, servers);

        Server newServer = new Server("10.0.0.3");
        consistentHash.add(newServer);

        // mapped to any of 3 servers
        System.out.println(consistentHash.getServer("key0"));
        System.out.println(consistentHash.getServer("key1"));
        System.out.println(consistentHash.getServer("key2"));
        System.out.println(consistentHash.getServer("key3"));
        System.out.println(consistentHash.getServer("key4"));

        consistentHash.remove(newServer);

        // mapped to only of available 2 servers
        System.out.println(consistentHash.getServer("key0"));
        System.out.println(consistentHash.getServer("key1"));
        System.out.println(consistentHash.getServer("key2"));
        System.out.println(consistentHash.getServer("key3"));
        System.out.println(consistentHash.getServer("key4"));
    }
}

class ConsistentHash {
    private int numberOfVirtualNode;

    private TreeMap<Long, Server> hashRing;

    public ConsistentHash(int numberOfVirtualNode, Collection<Server> servers) {
        this.numberOfVirtualNode = numberOfVirtualNode;
        this.hashRing = new TreeMap<>();

        if (servers != null) {
            for (Server server: servers) this.add(server);
        }
    }

    /**
     * Add virtual nodes while adding physical server
     *
     * @param server
     */
    public void add(Server server) {
        for (int i = 0; i < numberOfVirtualNode; i++) {
            hashRing.put(hash(i + server.getIp()), server);
        }
    }

    /**
     * Remove all virtual nodes while removing physical server
     * @param server
     */
    public void remove(Server server) {
        for (int i = 0; i < numberOfVirtualNode; i++) {
            hashRing.remove(hash(i + server.getIp()));
        }
    }

    /**
     * Get physical server the key mapped to
     * @param key
     * @return Server key belonging to
     */
    public Server getServer(String key) {
        if (hashRing.isEmpty()) return null;

        Long hashVal = hash(key);

        if (!hashRing.containsKey(hashVal)) {
            SortedMap<Long, Server> tailMap = hashRing.tailMap(hashVal);
            hashVal = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();
        }

        return hashRing.get(hashVal);
    }

    public Long hash(String key) {
        CRC32 crc =new CRC32();
        crc.update(key.getBytes());

        return crc.getValue();
    }
}

class Server {
    private String ip;

    public Server(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return ip;
    }
}

