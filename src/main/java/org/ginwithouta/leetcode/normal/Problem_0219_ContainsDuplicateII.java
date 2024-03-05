package org.ginwithouta.leetcode.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ginwithouta
 * Generate at 2023/12/28
 * Problem 存在重复元素Ⅱ
 */
public class Problem_0219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
         * 可以用一个 map 来存放每次遍历到的数字，然后每次遍历的时候判断当签数是否存在在 map 中，
         * 如果存在，就进行比对，看是否小于 k ，如不满足，我们就需要更新当前数的下标，让他变为当
         * 前位置，然后再去跟后面可能出现的数比较
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
