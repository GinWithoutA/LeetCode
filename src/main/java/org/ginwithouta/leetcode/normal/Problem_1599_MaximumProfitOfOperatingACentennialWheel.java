package org.ginwithouta.leetcode.normal;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2024/1/1
 * Problem 经营摩天轮的最大利润
 */
public class Problem_1599_MaximumProfitOfOperatingACentennialWheel {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        /*
         * 题目的含义是指过程中的最大利润用了多少次轮转，如果过程中没有最大利润，那么返回 -1
         */
        int totalProfit = 0, waitingCustomers = 0, curRound = 0, maxProfit = 0, ans = -1;
        while (waitingCustomers > 0 || curRound < customers.length) {
            waitingCustomers += curRound < customers.length ? customers[curRound] : 0;
            int board = Math.min(4, waitingCustomers);
            waitingCustomers -= board;
            ++curRound;
            totalProfit += board * boardingCost - runningCost;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                ans = curRound;
            }
        }
        return ans;
    }
}
