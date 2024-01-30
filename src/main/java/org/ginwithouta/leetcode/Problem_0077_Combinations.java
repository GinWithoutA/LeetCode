package org.ginwithouta.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/30
 * Problem 组合
 */
public class Problem_0077_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        process(n, 1, k, path, ans);
        return ans;
    }
    public void process(int n, int idx, int left, LinkedList<Integer> path, List<List<Integer>> ans) {
        if (n - idx + 1 < left) {
            return ;
        }
        if (idx > n || left == 0) {
            List<Integer> res = new ArrayList<>(path);
            ans.add(res);
            return;
        }
        for (int i = idx; i <= n; ++i) {
            path.addLast(i);
            // 每次只选比当前元素大的元素
            process(n, i + 1, left - 1, path, ans);
            path.pollLast();
        }
    }
}
