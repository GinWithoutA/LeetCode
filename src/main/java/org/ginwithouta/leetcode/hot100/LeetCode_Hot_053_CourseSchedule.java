package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.graph.Node;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/2/22
 * LeetCode Hot 100 课程表
 */
public class LeetCode_Hot_053_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        HashMap<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < numCourses; ++i) {
            nodes.put(i, new Node());
        }
        Set<Node> inSet = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            nodes.get(prerequisite[1]).nexts.add(nodes.get(prerequisite[0]));
            ++nodes.get(prerequisite[0]).in;
            inSet.add(nodes.get(prerequisite[0]));
        }
        Deque<Node> queue = new LinkedList<>();
        for (Node node : nodes.values()) {
            if (!inSet.contains(node)) {
                queue.offer(node);
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
