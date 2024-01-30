package org.ginwithouta.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/30
 * Problem 全排列
 */
public class Problem_0046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        process(nums, 0, ans);
        return ans;
    }
    public void process(int[] nums, int index, List<List<Integer>> ans) {
        if (index == nums.length) {
            ArrayList<Integer> res = new ArrayList<>();
            for (int num : nums) {
                res.add(num);
            }
            ans.add(res);
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            swap(nums, index, i);
            process(nums, i + 1, ans);
            swap(nums, index, i);
        }
    }
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
