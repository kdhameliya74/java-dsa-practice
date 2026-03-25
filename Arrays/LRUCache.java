package Arrays;

import java.util.LinkedHashMap;
import java.util.Map;

/*
 Problem: LRU Cache - Least Recently Used.

 - LRU is not just an idea — it’s a classic data structure + algorithm problem.
 - It often used when Fetching data repeatedly (API calls), Recomputing expensive values
 - LRU Cache is used in Frontend and Backend to avoid Avoid redundant API calls, Improve performance, Reduce memory usage.
 - Common use cases:
    - API Response Caching
    - Expensive Computation
    - Image / Resource Caching: Image / Resource Caching, Remove old ones automatically
*/


class LRUCache {
    private int capacity;
    private Map<Integer, Integer> cache;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>();
    }

    void put(int key, int value) {
        // check key exist, delete
        // set the new key
        // check capacity, exceed delete recently used
        if(this.cache.containsKey(key)) {
            this.cache.remove(key);
        }
        this.cache.put(key, value);

        if(this.cache.size() > this.capacity) {
            System.out.println("Removing least recently used");
            int firstKey = this.cache.keySet().iterator().next(); // least recently used
            this.cache.remove(firstKey);
        }
    }
    
    int get(int key) {
        // check key exist, if not return
        // if exist, delete and set as recently used
        if(!this.cache.containsKey(key)) return -1;
        int value = this.cache.get(key);
        this.cache.remove(key);
        this.cache.put(key, value); // set as recently used
        return value;
    }
    String getValues() {
        return this.cache.toString();
    }
}

class Cache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2,22);
        cache.put(3,32);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(4,42);
        cache.put(5,52);
        System.out.println(cache.getValues());
    }
}
