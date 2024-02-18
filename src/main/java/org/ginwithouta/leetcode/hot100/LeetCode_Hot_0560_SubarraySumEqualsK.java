package org.ginwithouta.leetcode.hot100;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Ginwithouta
 * Generate at 2024/2/18
 * LeetCode Hot 100 和为 K 的子数组
 */
public class LeetCode_Hot_0560_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        /*
         * 用类似两数之和的做法，记录每个累加和出现的次数，每次加上就行了
         */
        int ans = 0, preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - k)) {
                ans += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}
