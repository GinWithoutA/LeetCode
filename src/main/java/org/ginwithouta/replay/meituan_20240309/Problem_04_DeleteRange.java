package org.ginwithouta.replay.meituan_20240309;

/**
 * @author Ginwithouta
 * Generate at 2024/3/9
 * 美团 春招 20240309 复盘 区间删除
 */
public class Problem_04_DeleteRange {
    /**
     * 给定一个数组，要求删除数组中的特定区间，使得剩余数字的乘积包含k个0，问有多少种删除的方法
     */
    public int solve(int[] nums, int k) {
        /*
         * 首先思路就是求2和5的数量，然后计算每个可能区间，删除后剩下多少个2和5的对子，如果大于等于k就可以返回
         */
        int[] prefixTwo = new int[nums.length + 1], prefixFive = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            prefixTwo[i + 1] = prefixTwo[i] + count(nums[i], 2);
            prefixFive[i + 1] = prefixFive[i] + count(nums[i], 5);
        }
        int ans = 0;
        for (int left = 0; left <= nums.length; ++left) {
            for (int right = 1; right <= nums.length; ++right) {
                int countTwo = prefixTwo[nums.length] - (prefixTwo[right] - (left > 0 ? prefixTwo[left - 1] : 0));
                int countFive = prefixFive[nums.length] - (prefixFive[right] - (left > 0 ? prefixFive[left - 1] : 0));
                if (Math.min(countTwo, countFive) >= k) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    public int count(int num, int factor) {
        int ans = 0;
        while (num != 0 && num % factor == 0) {
            ++ans;
            num /= factor;
        }
        return ans;
    }
}
