package org.ginwithouta.replay.meituan_20240309;

/**
 * @author Ginwithouta
 * Generate at 2024/3/9
 * 美团 春招 20240309 复盘 数组询问
 */
public class Problem_02_QueryArray {
    /**
     * 给定一个数组，数组中值为0的元素表示当前值未知，给定q个区间[l,r]，未知的元素在这个区间上，求每个区间数组的最小值和最大值
     */
    public long[][] solve(int[] nums, int[][] query) {
        long[][] ans = new long[query.length][2];
        long sum = 0L;
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                ++count;
            } else {
                sum += num;
            }
        }
        for (int i = 0; i < ans.length; ++i) {
            ans[i][0] = sum + (long) count * query[i][0];
            ans[i][1] = sum + (long) count * query[i][1];
        }
        return ans;
    }
}
