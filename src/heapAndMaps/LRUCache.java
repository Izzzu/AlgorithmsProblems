package heapAndMaps;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


public class LRUCache {

        private int capacity;
        private Map<Integer, Integer> map;
        private Deque<Integer> dq;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.dq = new ArrayDeque<>();
            map.clear();

        }

        public int get(int key) {
            if (map.containsKey(key)) {
                dq.removeFirstOccurrence(key);
                dq.push(key);
                return map.get(key);
            } else {
                return -1;
            }
        }

        public void set(int key, int value) {

            if (!map.containsKey(key)) {
                if(dq.size() == capacity) {
                    Integer last = dq.pollLast();
                    map.remove(last);
                }
            } else {
                dq.removeFirstOccurrence(key);
            }
            dq.push(key);
            map.put(key, value);
        }

        public static void main(String[] args) {
            LRUCache lruCache = new LRUCache(4);
            lruCache.set(5, 13);
            lruCache.set(9, 6);
            lruCache.set(4, 1);
            System.out.println(lruCache.get(4));
            lruCache.set(6, 1);
            lruCache.set(8, 11);
            System.out.println(lruCache.get(13));
            System.out.println(lruCache.get(1));
            lruCache.set(12, 12);
            System.out.println(lruCache.get(10));
            lruCache.set(15, 13);
            lruCache.set(2, 13);
            lruCache.set(7, 5);
            lruCache.set(10, 3);
            System.out.println(lruCache.get(6));
            System.out.println(lruCache.get(10));
            lruCache.set(15, 14);
            lruCache.set(5, 12);
            System.out.println(lruCache.get(5));
            System.out.println(lruCache.get(7));
            System.out.println(lruCache.get(15));
            System.out.println(lruCache.get(5));
            System.out.println(lruCache.get(6));
            System.out.println(lruCache.get(10));
            lruCache.set(7, 13);
            System.out.println(lruCache.get(14));
            lruCache.set(8, 9);
            System.out.println(lruCache.get(4));
            lruCache.set(6, 11);
            System.out.println(lruCache.get(9));
            lruCache.set(6, 12);
            System.out.println(lruCache.get(3));
        }

    }

// 32 4 S 5 13 S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G 1 S 12 12 G 10 S 15 13 S 2 13 S 7 5 S 10 3 G 6 G 10 S 15 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G 10 S 7 13 G 14 S
// 8 9 G 4 S 6 11 G 9 S 6 12 G 3
