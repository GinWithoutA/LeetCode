package org.ginwithouta.leetcode.hot100;

import lombok.val;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Ginwithouta
 * Generate at 2024/2/21
 * LeetCode Hot 100 LRU缓存
 */
public class LeetCode_Hot_0146_LRUCache {

    public static class CacheNode<K, V> {
        private V val;
        private K key;
        private CacheNode<K, V> prev;
        private CacheNode<K, V> next;
        public CacheNode(K key, V val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    public static class CacheQueue<K, V> {
        private CacheNode<K, V> head;
        private CacheNode<K, V> tail;
        public CacheQueue() {
            this.head = null;
            this.tail = null;
        }

        public void addNode(CacheNode<K, V> node) {
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

        public void moveNodeToTail(CacheNode<K, V> node) {
            if (node == null) {
                return;
            }
            if (node == this.tail) {
                return;
            }
            if (node == this.head) {
                this.head = node.next;
                this.head.prev = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.next = null;
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }

        public void removeNode() {
            if (this.head == null) {
                return;
            }
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.prev = null;
            }
        }
    }

    public static class Cache<K, V> {
        private int capacity;
        private HashMap<K, CacheNode<K, V>> map;
        private CacheQueue<K, V> queue;

        public Cache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>(capacity);
            this.queue = new CacheQueue<>();
        }

        public V get(K key) {
            if (this.map.containsKey(key)) {
                CacheNode<K, V> node = this.map.get(key);
                this.queue.moveNodeToTail(node);
                return node.val;
            }
            return null;
        }

        public void put(K key, V value) {
            if (this.map.containsKey(key)) {
                CacheNode<K, V> node = this.map.get(key);
                node.val = value;
                this.queue.moveNodeToTail(node);
            } else {
                if (this.map.size() == this.capacity) {
                    this.map.remove(this.queue.head.key);
                    this.queue.removeNode();
                }
                CacheNode<K, V> node = new CacheNode<>(key, value);
                this.map.put(key, node);
                this.queue.addNode(node);
            }
        }
    }

    public static class LRUCache {
        private Cache<Integer, Integer> cache;

        public LRUCache(int capacity) {
            this.cache = new Cache<>(capacity);
        }

        public int get(int key) {
            Integer value = this.cache.get(key);
            return value == null ? -1 : value;
        }

        public void put(int key, int value) {
            this.cache.put(key, value);
        }
    }
}
