package misc;

import java.util.*;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> map;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        // Explanation:
        // Use LinkedHashMap with accessOrder=true to maintain LRU order.
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
        this.map = cache;
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
        if (map.size() > capacity) {
            int oldest = map.keySet().iterator().next();
            map.remove(oldest);
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // Expected: 1
        lru.put(3, 3); // Evicts key 2
        System.out.println(lru.get(2)); // Expected: -1
    }
}

