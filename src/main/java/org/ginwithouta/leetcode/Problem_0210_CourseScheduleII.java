package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.graph.Node;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/1/29
 * Problem 课程表Ⅱ
 */
public class Problem_0210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
         * 拓扑图经典题目
         */
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) {
            nodes.put(i, new Node(i));
        }
        Set<Node> inSet = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            ++nodes.get(prerequisite[0]).in;
            nodes.get(prerequisite[1]).nexts.add(nodes.get(prerequisite[0]));
            inSet.add(nodes.get(prerequisite[0]));
        }
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (!inSet.contains(nodes.get(i))) {
                queue.offer(nodes.get(i));
            }
        }
        if (queue.isEmpty()) {
            return new int[0];
        }
        int idx = 0;
        int[] ans = new int[numCourses];
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            ans[idx++] = cur.val;
            for (Node next : cur.nexts) {
                if (--next.in == 0) {
                    inSet.remove(next);
                    queue.offer(next);
                }
            }
        }
        return inSet.isEmpty() ? ans : new int[0];
    }
}
