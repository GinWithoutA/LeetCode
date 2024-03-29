package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/29
 * LeetCode 面试经典 150 加油站
 */
public class LeetCode_Interview_014_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
         * 首先我们计算 gas[i] - cost[i] 表示从每个站点出发到下一个站点的剩余油量。接着计算前缀和，利用前缀和可以计算
         * 从每一个站点出发到达末尾需要的总油量。然后，我们利用单调栈，记录每 gas.length 长度下窗口中的最小值，也就是
         * 单调栈单调递增，若当前窗口中的最小值大于 0，那么就表示整体的油量一定能够到达末尾
         */
        int[] help = new int[gas.length * 2];
        for (int i = 0; i < gas.length; ++i) {
            help[i] = gas[i] - cost[i];
            help[i + gas.length] = help[i];
        }
        for (int i = 1; i < help.length; ++i) {
            help[i] = help[i] + help[i - 1];
        }
        int[] stack = new int[gas.length];
        int top = -1;
        for (int right = 0; right < gas.length; ++right) {
            while (top != -1 && help[stack[top]] > help[right]) {
                --top;
            }
            stack[++top] = right;
        }
        if (help[stack[0]] >= 0) {
            return 0;
        }
        for (int right = gas.length; right < help.length; ++right) {
            while (top != -1 && help[stack[top]] > help[right]) {
                --top;
            }
            stack[++top] = right;
            if (help[stack[0]] - help[right - gas.length] >= 0) {
                return right - gas.length + 1;
            }
        }
        return -1;
    }
}
