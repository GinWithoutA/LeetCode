package org.ginwithouta.leetcode.interview150;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/4/9
 * LeetCode 面试经典 150 课程表
 */
public class LeetCode_Interview_089_CourseSchedule {
    public static class Node {
        int in;
        List<Node> nexts;
        public Node() {
            this.in = 0;
            this.nexts = new ArrayList<>();
        }
    }
    public boolean canFinish(int numCourse, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        Node[] nodes = new Node[numCourse];
        for (int i = 0; i < nodes.length; ++i) {
            nodes[i] = new Node();
        }
        Set<Node> inSet = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            nodes[prerequisite[1]].nexts.add(nodes[prerequisite[0]]);
            ++nodes[prerequisite[0]].in;
            inSet.add(nodes[prerequisite[0]]);
        }
        Deque<Node> queue = new ArrayDeque<>();
        for (Node node : nodes) {
            if (!inSet.contains(node)) {
                queue.offerLast(node);
            }
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node next : cur.nexts) {
                if (--next.in == 0) {
                    inSet.remove(next);
                    queue.offer(next);
                }
            }
        }
        return inSet.isEmpty();
    }
}
