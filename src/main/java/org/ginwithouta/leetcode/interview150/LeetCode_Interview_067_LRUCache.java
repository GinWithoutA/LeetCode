package org.ginwithouta.leetcode.interview150;
import java.util.HashMap;

/**
 * @author Ginwithouta
 * Generate at 2024/4/7
 * LeetCode 面试经典 150 LRU缓存
 */
public class LeetCode_Interview_067_LRUCache {
    static class CacheNode<K, V> {
        K key;
        V value;
        CacheNode<K, V> prev;
        CacheNode<K, V> next;
        public CacheNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    static class CacheList<K, V> {
        CacheNode<K, V> head;
        CacheNode<K, V> tail;
        public CacheList() {
            this.head = null;
            this.tail = null;
        }
        public void add(CacheNode<K, V> node) {
            if (node == null) {
                return;
            }
            if (this.head == null) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
                this.tail = node;
            }
        }
        public void remove() {
            if (this.head == null) {
                return;
            }
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.prev.next = null;
            }
        }
        public void moveToTail(CacheNode<K, V> node) {
            if (node == null || node == this.tail) {
                return;
            }
            if (node == this.head) {
                this.head = node.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            this.tail.next = node;
            node.prev = this.tail;
            node.next = null;
            this.tail = node;
        }
    }
    static class Cache<K, V> {
        int capacity;
        HashMap<K, CacheNode<K, V>> map;
        CacheList<K, V> list;
        public Cache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.list = new CacheList<>();
        }
        public V get(K key) {
            if (!this.map.containsKey(key)) {
                return null;
            }
            CacheNode<K, V> node = this.map.get(key);
            this.list.moveToTail(node);
            return node.value;
        }
        public void put(K key, V value) {
            if (this.map.containsKey(key)) {
                this.map.get(key).value = value;
                this.list.moveToTail(this.map.get(key));
            } else {
                if (this.map.size() == this.capacity) {
                    this.map.remove(this.list.head.key);
                    this.list.remove();
                }
                this.map.put(key, new CacheNode<>(key, value));
                this.list.add(this.map.get(key));
            }
        }
    }
    static class LRUCache {
        Cache<Integer, Integer> cache;
        public LRUCache(int capacity) {
            this.cache = new Cache<>(capacity);
        }

        public int get(int key) {
            Integer ans = this.cache.get(key);
            return ans == null ? -1 : ans;
        }

        public void put(int key, int value) {
            this.cache.put(key, value);
        }
    }
}
