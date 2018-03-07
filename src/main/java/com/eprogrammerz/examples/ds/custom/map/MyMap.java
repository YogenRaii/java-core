package com.eprogrammerz.examples.ds.custom.map;

public class MyMap<K, V> {
    private Entry<K,V>[] buckets;
    private int capacity = 2;

    public MyMap() {
        this.buckets = new Entry[capacity];
    }

    public void put(K key, V value) {
        int hash = getHash(key);
        Entry<K, V> entry = new Entry<>(hash, key, value, null);

        int bucket = hash % getBucketSize();

        Entry<K, V> existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = entry;
        } else {
            // compare the keys see if key already exists
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }

            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
            }
        }
    }

    private int getBucketSize() {
        return capacity;
    }

    private int getHash(K key) {
        return key == null ? 0 : key.hashCode();
    }

    public V get(K key) {
        return null;
    }

    static class Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Entry<K,V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getHash() {
            return hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry entry: buckets) {
            sb.append("[");
            while (entry != null) {
                sb.append(entry);
                if (entry.next != null) {
                    sb.append(", ");
                }
                entry = entry.next;
            }
            sb.append("]");
        }
        return "[" + sb.toString() + "]";
    }

}
