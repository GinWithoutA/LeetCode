package org.ginwithouta.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/23
 * LeetCode Hot 100 分割回文串
 */
public class LeetCode_Hot_061_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        char[] strs = s.toCharArray();
        process(ans, path, strs, getDp(strs), 0);
        return ans;
    }
    public boolean[][] getDp(char[] strs) {
        boolean[][] dp = new boolean[strs.length][strs.length];
        dp[strs.length - 1][strs.length - 1] = true;
        for (int i = 0; i < strs.length - 1; ++i) {
            dp[i][i] = true;
            dp[i][i + 1] = strs[i] == strs[i + 1];
        }
        for (int i = strs.length - 3; i >= 0; --i) {
            for (int j = i + 2; j < strs.length; ++j) {
                dp[i][j] = dp[i + 1][j - 1] && strs[i] == strs[j];
            }
        }
        return dp;
    }
    public void process(List<List<String>> ans, List<String> path, char[] strs, boolean[][] dp, int idx) {
        if (idx == strs.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < strs.length; ++i) {
            if (dp[idx][i]) {
                path.add(String.valueOf(strs, idx, i - idx + 1));
                process(ans, path, strs, dp, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
