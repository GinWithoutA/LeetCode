package org.ginwithouta.leetcode.interview150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Ginwithouta
 * Generate at 2024/4/11
 * LeetCode 面试经典 150 蛇梯棋
 */
public class LeetCode_Interview_091_SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] vis = new int[n * n + 1];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerLast(new int[] {1, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();
            for(int i = 1; i < 7; ++i) {
                int next = cur[0] + i;
                if (next > n * n) {
                    break;
                }
                int[] rc = id2rc(next, n);
                if (board[rc[0]][rc[1]] > 0) {
                    next = board[rc[0]][rc[1]];
                }
                if (next == n * n) {
                    return cur[1] + 1;
                }
                if (vis[next] == 0) {
                    vis[next] = 1;
                    queue.offerLast(new int[] {next, cur[1] + 1});
                }
            }
        }
        return -1;
    }
    private int[] id2rc(int idx, int n) {
        /*
         * 获取 idx 对应的行和列
         */
        int row = (idx - 1) / n, col = (idx - 1) % n;
        if (row % 2 == 1) {
            col = n - 1 - col;
        }
        return new int[] {n - 1 - row, col};
    }
}
