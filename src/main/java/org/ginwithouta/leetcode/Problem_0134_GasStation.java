package org.ginwithouta.leetcode;

import java.util.LinkedList;

/**
 * @author Ginwithouta
 * Generate at 2023/12/6
 * Problem 加油站
 */
public class Problem_0134_GasStation {

    /**
     * 解法一：滑动窗口
     */
    public int canCompleteCircuitWindow(int[] gas, int[] cost) {
        /*
         * 整个题目的思路就是利用前缀和数组，每 gas.length 长度为一个指标，如果当前前缀和中最小值都是大于等于 0 ，那么表示从
         * 当前滑动窗口的开始位置出发，一定能到达结束位置
         *
         * 在这个解法中，我们用一个滑动窗口记录当前窗口内最小的值，保证其按照从小到大的顺序排列，每次滑动窗口滑动，就判断当前
         * 窗口内最小值是否大于等于 0
         */
        if (gas.length == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }
        // 构建一个 help 数组，存储每个位置出发的油量 - 耗油量，然后计算每个位置的前缀和
        int[] help = new int[gas.length * 2];
        for (int i = 0; i < gas.length; ++i) {
            help[i] = gas[i] - cost[i];
            help[i + gas.length] = help[i];
        }
        for (int i = 1; i < help.length; ++i) {
            help[i] += help[i - 1];
        }
        LinkedList<Integer> minWindow = new LinkedList<>();
        // 初始化一个滑动窗口，让其记录 gas 长度中的数，让其从小到大排列，保证每次滑动窗口移动，里面的值都是当前滑动窗口中最薄弱的部分
        for (int right = 0; right < gas.length; ++right) {
            while (!minWindow.isEmpty() && help[minWindow.peekLast()] > help[right]) {
                minWindow.pollLast();
            }
            minWindow.addLast(right);
        }
        // 若当前滑动窗口中的最小值都大于 0 ，那么从 0 号加油站出发就能遍历所有的加油站了
        if (help[minWindow.peekFirst()] >= 0) {
            return 0;
        }
        for (int right = gas.length; right < help.length; ++right) {
            while (!minWindow.isEmpty() && help[minWindow.peekLast()] > help[right]) {
                minWindow.pollLast();
            }
            minWindow.addLast(right);
            if (help[minWindow.peekFirst()] - help[right - gas.length] >= 0) {
                return right - gas.length + 1;
            }
        }
        return -1;
    }

}
