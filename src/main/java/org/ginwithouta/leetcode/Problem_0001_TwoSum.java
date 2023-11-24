package org.ginwithouta.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ginwithouta
 * Generate at 2023/11/24
 * Problem 两数之和
 */
public class Problem_0001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        /*
         * 用一个 Map，Key 表示 target 减去当前元素还剩余的值，每遍历一个元素就判断当前元素是否存在 map 中，
         * 如果存在，就表明这两个数就是需要的两数之和
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
