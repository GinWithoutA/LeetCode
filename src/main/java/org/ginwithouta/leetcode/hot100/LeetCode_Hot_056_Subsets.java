package org.ginwithouta.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/23
 * LeetCode Hot 100 子集
 */
public class LeetCode_Hot_056_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        process(ans, path, nums, 0);
        return ans;
    }
    public void process(List<List<Integer>> ans, List<Integer> path, int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        process(ans, path, nums, index + 1);
        path.add(nums[index]);
        process(ans, path, nums, index + 1);
        path.remove(path.size() - 1);
    }
}

