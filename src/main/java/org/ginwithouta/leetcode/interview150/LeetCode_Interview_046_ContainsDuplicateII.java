package org.ginwithouta.leetcode.interview150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ginwithouta
 * Generate at 2024/4/5
 * LeetCode 面试经典 150 存在重复元素Ⅱ
 */
public class LeetCode_Interview_046_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
