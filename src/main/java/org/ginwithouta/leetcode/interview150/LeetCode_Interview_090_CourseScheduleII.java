package org.ginwithouta.leetcode.interview150;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/4/9
 * LeetCode 面试经典 150 课程表Ⅱ
 */
public class LeetCode_Interview_090_CourseScheduleII {
    public static class Node{
        public int val;
        public int in;
        public List<Node> nexts;
        public Node(int val) {
            this.val = val;
            this.in = 0;
            this.nexts = new ArrayList<>();
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int cur = 0;
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            nodes[i] = new Node(i);
        }
        Set<Node> inSet = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            nodes[prerequisite[1]].nexts.add(nodes[prerequisite[0]]);
            inSet.add(nodes[prerequisite[0]]);
            ++nodes[prerequisite[0]].in;
        }
        Deque<Node> queue = new ArrayDeque<>();
        for (Node node : nodes) {
            if (!inSet.contains(node)) {
                ans[cur++] = node.val;
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for(Node next : node.nexts) {
                if (--next.in == 0) {
                    inSet.remove(next);
                    queue.offer(next);
                    ans[cur++] = next.val;
                }
            }
        }
        return inSet.isEmpty() ? ans : new int[0];
    }
}
