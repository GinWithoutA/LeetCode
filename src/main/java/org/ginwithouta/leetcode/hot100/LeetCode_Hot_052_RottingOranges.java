package org.ginwithouta.leetcode.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Ginwithouta
 * Generate at 2024/2/22
 * LeetCode Hot 100 腐烂的桔子
 */
public class LeetCode_Hot_052_RottingOranges {
    public int orangesRotting(int[][] grid) {
        /*
         * 广度优先
         */
        int fresh = 0, step = 0;
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    ++fresh;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        while (!queue.isEmpty()) {
            int queueCurSize = queue.size();
            ++step;
            while (queueCurSize != 0) {
                int[] cord = queue.poll();
                if (cord[0] + 1 < grid.length && grid[cord[0] + 1][cord[1]] == 1) {
                    --fresh;
                    grid[cord[0] + 1][cord[1]] = 2;
                    queue.offer(new int[] {cord[0] + 1, cord[1]});
                }
                if (cord[0] - 1 >= 0 && grid[cord[0] - 1][cord[1]] == 1) {
                    --fresh;
                    grid[cord[0] - 1][cord[1]] = 2;
                    queue.offer(new int[] {cord[0] - 1, cord[1]});
                }
                if (cord[1] + 1 < grid[0].length && grid[cord[0]][cord[1] + 1] == 1) {
                    --fresh;
                    grid[cord[0]][cord[1] + 1] = 2;
                    queue.offer(new int[] {cord[0], cord[1] + 1});
                }
                if (cord[1] - 1 >= 0 && grid[cord[0]][cord[1] - 1] == 1) {
                    --fresh;
                    grid[cord[0]][cord[1] - 1] = 2;
                    queue.offer(new int[] {cord[0], cord[1] - 1});
                }
                --queueCurSize;
            }
            if (fresh == 0) {
                return step;
            }
        }
        return -1;
    }

}
