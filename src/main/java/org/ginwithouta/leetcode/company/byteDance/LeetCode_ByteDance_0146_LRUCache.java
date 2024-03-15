package org.ginwithouta.leetcode.company.byteDance;

import java.util.HashMap;

/**
 * @author Ginwithouta
 * Generate at 2024/3/15
 * LeetCode 字节跳动 LRU缓存
 */
public class LeetCode_ByteDance_0146_LRUCache {
    public static class CacheNode<K, V> {
        public K key;
        public V value;
        public CacheNode<K, V> prev;
        public CacheNode<K, V> next;
        public CacheNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public static class CacheQueue<K, V> {
        public CacheNode<K, V> head;
        public CacheNode<K, V> tail;

        public CacheQueue() {
            this.head = null;
            this.tail = null;
        }

        public void add(CacheNode<K, V> node) {
            if (node == null) {
                return;
            }
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }
            this.tail = node;
        }

        public void moveToTail(CacheNode<K, V> node) {
            if (node == null || node == this.tail) {
                return;
            }
            if (node == this.head) {
                node.next.prev = null;
                this.head = node.next;
            } else {
                node.next.prev = node.prev;
                node.prev.next = node.next;
            }
            this.tail.next = node;
            node.prev = this.tail;
            node.next = null;
            this.tail = node;
        }

        public void remove() {
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
        public int capacity;
        public HashMap<K, CacheNode<K, V>> nodes;
        public CacheQueue<K, V> queue;

        public Cache(int capacity) {
            this.capacity = capacity;
            this.nodes = new HashMap<>();
            this.queue = new CacheQueue<>();
        }

        public V get(K key) {
            CacheNode<K, V> node = this.nodes.getOrDefault(key, null);
            if (node == null) {
                return null;
            } else {
                this.queue.moveToTail(node);
                return node.value;
            }
        }

        public void put(K key, V value) {
            CacheNode<K, V> node = this.nodes.getOrDefault(key, null);
            if (node != null) {
                node.value = value;
                this.queue.moveToTail(node);
            } else {
                node = new CacheNode<>(key, value);
                if (this.capacity == this.nodes.size()) {
                    this.nodes.remove(this.queue.head.key);
                    this.queue.remove();
                }
                this.nodes.put(key, node);
                this.queue.add(node);
            }
        }
    }

    public static class LRUCache {
        public Cache<Integer, Integer> cache;
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
