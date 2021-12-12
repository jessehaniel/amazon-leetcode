package dev.jessehaniel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache extends LinkedHashMap<Integer, Integer> {

    // Design a data structure that follows the constraints of the Least Recently Used (LRU) cache.
    //
    // Implement the LRUCache class:
    //
    // LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    // int get(int key) Return the value of the key if the key exists, otherwise return -1.
    // void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair
    // to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    //
    // The functions get and put must each run in O(1) average time complexity.

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        LRUCache lruCache = (LRUCache) o;
        return capacity == lruCache.capacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacity);
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        obj.put(4, 4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }

}
