package org.ginwithouta.leetcode.hot100;

import java.util.HashSet;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/3/4
 * LeetCode Hot 100 单词拆分
 */
public class LeetCode_Hot_086_WordBreak {
    /**
     * 暴力递归
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return process(s, set, 0);
    }

    public boolean process(String s, HashSet<String> set, int idx) {
        if (idx == s.length()) {
            return true;
        }
        for (int end = idx; end < s.length(); ++end) {
            if (set.contains(s.substring(idx, end + 1)) && process(s, set, end + 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int[] dp = new int[s.length() + 1];
        dp[dp.length - 1] = 1;
        for (int idx = dp.length - 2; idx >= 0; --idx) {
            for (int end = idx; end < s.length(); ++end) {
                if (set.contains(s.substring(idx, end + 1))) {
                    dp[idx] += dp[end + 1];
                }
            }
        }
        return dp[0] > 0;
    }

    /**
     * 考虑当前位置之前是否能够拆分单词
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}
