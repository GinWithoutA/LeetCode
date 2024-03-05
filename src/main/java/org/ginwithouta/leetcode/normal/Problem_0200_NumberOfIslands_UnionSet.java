package org.ginwithouta.leetcode.normal;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/1/27
 * Problem 岛屿数量 并查集版本
 */
public class Problem_0200_NumberOfIslands_UnionSet {
    public static class Dot{}

    public static class Node<T> {
        public T value;
        public Node(T value) { this.value = value; }
    }

    public static class UnionSet<V> {
        public HashMap<V, Node<V>> nodes;
        public HashMap<Node<V>, Node<V>> parents;
        public HashMap<Node<V>, Integer> sizeMaps;

        public UnionSet(List<V> values) {
            this.nodes = new HashMap<>();
            this.parents = new HashMap<>();
            this.sizeMaps = new HashMap<>();
            for (V value : values) {
                Node<V> node = new Node<>(value);
                nodes.put(value, node);
                parents.put(node, node);
                sizeMaps.put(node, 1);
            }
        }

        /**
         * 找到当前节点的父亲节点，同时把道路上的所有节点的父亲直接指向最高层的父亲节点
         */
        public Node<V> find(V value) {
            Deque<Node<V>> stack = new ArrayDeque<>();
            Node<V> cur = this.nodes.get(value);
            while (cur != parents.get(cur)) {
                stack.push(cur);
                cur = parents.get(cur);
            }
            while (!stack.isEmpty()) {
                this.parents.put(stack.pop(), cur);
            }
            return cur;
        }

        /**
         * 合并两个节点所在的集合
         */
        public void union(V left, V right) {
            Node<V> leftNode = this.find(left), rightNode = this.find(right);
            if (leftNode != rightNode) {
                int leftSize = this.sizeMaps.get(leftNode), rightSize = this.sizeMaps.get(rightNode);
                Node<V> big = leftSize > rightSize ? leftNode : rightNode, small = big == leftNode ? rightNode : leftNode;
                parents.put(small, big);
                sizeMaps.put(big, leftSize + rightSize);
                sizeMaps.remove(small);
            }
        }
    }

    public int numIslands(char[][] grid) {
        /*
         * 利用并查集，对每个点查看左边和上面的内容是否能够合并，如果能够合并，则进行合并
         */
        Dot[][] dots = new Dot[grid.length][grid[0].length];
        List<Dot> dotList = new ArrayList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    dots[i][j] = new Dot();
                    dotList.add(dots[i][j]);
                }
            }
        }
        if (dotList.size() == 0) {
            return 0;
        }
        UnionSet<Dot> unionSet = new UnionSet<>(dotList);
        for (int i = 1; i < grid[0].length; ++i) {
            if (grid[0][i] == '1' && grid[0][i - 1] == '1') {
                unionSet.union(dots[0][i], dots[0][i - 1]);
            }
        }
        for (int i = 1; i < grid.length; ++i) {
            if (grid[i][0] == '1' && grid[i - 1][0] == '1') {
                unionSet.union(dots[i][0], dots[i - 1][0]);
            }
        }
        for (int i = 1; i < grid.length; ++i) {
            for (int j = 1; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    if (grid[i - 1][j] == '1') {
                        unionSet.union(dots[i][j], dots[i - 1][j]);
                    }
                    if (grid[i][j - 1] == '1') {
                        unionSet.union(dots[i][j], dots[i][j - 1]);
                    }
                }
            }
        }
        return unionSet.sizeMaps.size();
    }
}
