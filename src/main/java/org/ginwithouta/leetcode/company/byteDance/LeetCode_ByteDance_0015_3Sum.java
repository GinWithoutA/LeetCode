package org.ginwithouta.leetcode.company.byteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/3/15
 * LeetCode 字节跳动 三数之和
 */
public class LeetCode_ByteDance_0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = nums.length - 1; i > 1; --i) {
            if (i == nums.length - 1 || nums[i] != nums[i + 1]) {
                List<List<Integer>> res = twoSum(nums, i - 1, -nums[i]);
                for (List<Integer> item : res) {
                    item.add(nums[i]);
                    ans.add(item);
                }
            }
        }
        return ans;
    }

    private List<List<Integer>> twoSum(int[] nums, int end, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int idx = 0;
        while (idx < end) {
            if (nums[idx] + nums[end] > target) {
                --end;
            } else if (nums[idx] + nums[end] < target) {
                ++idx;
            } else {
                if (idx == 0 || nums[idx] != nums[idx - 1]) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[idx]);
                    res.add(nums[end]);
                    ans.add(res);
                }
                ++idx;
            }
        }
        return ans;
    }
}
