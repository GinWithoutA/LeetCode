package org.ginwithouta.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/23
 * LeetCode Hot 100 组合总和
 */
public class LeetCode_Hot_058_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        process(ans, path, candidates, target, 0);
        return ans;
    }
    public void process(List<List<Integer>> ans, List<Integer> path, int[] candidates, int target, int index) {
        if (index == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        process(ans, path, candidates, target, index + 1);
        if (target - candidates[index] >= 0) {
            path.add(candidates[index]);
            process(ans, path, candidates, target - candidates[index], index);
            path.remove(path.size() - 1);
        }
    }
}
