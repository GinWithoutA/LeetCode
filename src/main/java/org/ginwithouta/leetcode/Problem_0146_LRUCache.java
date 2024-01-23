package org.ginwithouta.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ginwithouta
 * Generate at 2024/1/23
 * Problem LRU（最近最少使用）缓存
 */
public class Problem_0146_LRUCache {

    /*
     * 由于 get 和 put 都需要 O(1) 的时间完成，我们可以很容易想到用一个 map 存放每个缓存的位置，
     * 然后用一个链表来维护每个缓存，从而实现 O(1) 的 put。为了方便操作，这个链表最好是双向链表，
     * 能够更快的删除和插入，同时我们需要一个自定义的结点类，用来封装缓存的 key 和 value
     */

    public static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> pre;
        public Node<K, V> next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }

    public static class NodeDoubleLinkedList<K, V> {
        public Node<K, V> head;
        public Node<K, V> tail;

        public NodeDoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addNode(Node<K, V> node) {
            if (node == null) {
                return ;
            }
            if (this.head == null) {
                this.head = node;
                this.tail = node;
            } else {
                this.tail.next = node;
                node.pre = this.tail;
                this.tail = node;
            }
        }

        /**
         * 每次有某一个缓存被使用，就要移动，更改他们对应的顺序
         * 每次需要删除缓存的时候，都是从头开始删除
         */
        public void moveNodeToTail(Node<K, V> node) {
            if (node == this.tail) {
                return;
            }
            if (node == this.head) {
                this.head = node.next;
                this.head.pre = null;
            } else {
                node.next.pre = node.pre;
                node.pre.next = node.next;
            }
            node.next = null;
            node.pre = this.tail;
            this.tail.next = node;
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
                this.head.pre.next = null;
                this.head.pre = null;
            }
        }
    }

    public static class MyCache<K, V> {
        public int capacity;
        public Map<K, Node<K, V>> map;
        public NodeDoubleLinkedList<K, V> list;

        public MyCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.list = new NodeDoubleLinkedList<>();
        }

        public V get(K key) {
            if (this.map.containsKey(key)) {
                Node<K, V> node = map.get(key);
                this.list.moveNodeToTail(node);
                return node.value;
            }
            return null;
        }

        public void put(K key, V value) {
            if (this.map.containsKey(key)) {
                Node<K, V> node = map.get(key);
                node.value = value;
                this.list.moveNodeToTail(node);
            } else {
                if (this.map.size() == this.capacity) {
                    this.map.remove(this.list.head.key);
                    this.list.removeNode();
                }
                Node<K, V> node = new Node<>(key, value);
                this.map.put(key, node);
                this.list.addNode(node);
            }
        }
    }
}
