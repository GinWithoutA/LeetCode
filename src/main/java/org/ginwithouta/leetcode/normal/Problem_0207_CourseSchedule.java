package org.ginwithouta.leetcode.normal;

import org.ginwithouta.leetcode.common.graph.Node;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/1/29
 * Problem 课程表
 */
public class Problem_0207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
         * 拓扑图经典题
         */
        if (prerequisites.length == 0) {
            return true;
        }
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) {
            nodes.put(i, new Node(i));
        }
        Set<Node> inSet = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            nodes.get(prerequisite[1]).nexts.add(nodes.get(prerequisite[0]));
            ++nodes.get(prerequisite[0]).in;
            inSet.add(nodes.get(prerequisite[0]));
        }
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (!inSet.contains(nodes.get(i))) {
                queue.add(nodes.get(i));
            }
        }
        if (queue.isEmpty()) {
            return false;
        }
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node next : cur.nexts) {
                if (--next.in == 0) {
                    queue.offer(next);
                    inSet.remove(next);
                }
            }
        }
        return inSet.isEmpty();
    }
}
