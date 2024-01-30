package org.ginwithouta.leetcode;

import javax.swing.plaf.basic.BasicTreeUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/30
 * Problem 组合总和
 */
public class Problem_0039_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
         * 这道题有一个点就是可以不选当前的元素，这一个可以通过直接 index + 1 去完成，这是因为在后续的过程中，
         * 也会进行添加当前元素和不添加当前元素的选择
         */
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        process(candidates, 0, ans, path, target);
        return ans;
    }
    public void process(int[] candidates, int index, List<List<Integer>> ans, LinkedList<Integer> path, int left) {
        if (left == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        // 不选
        process(candidates, index + 1, ans, path, left);
        if (left - candidates[index] >= 0) {
            path.addLast(candidates[index]);
            process(candidates, index, ans, path, left - candidates[index]);
            path.pollLast();
        }
    }
}
