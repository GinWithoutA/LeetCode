package org.ginwithouta.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/23
 * LeetCode Hot 100 分割回文串 递归版本
 */
public class LeetCode_Hot_061_PalindromePartitioning2 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        char[] strs = s.toCharArray();
        process(ans, path, strs, 0);
        return ans;
    }
    public void process(List<List<String>> ans, List<String> path, char[] strs, int idx) {
        if (idx == strs.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < strs.length; ++i) {
            if (isPalindrome(strs, idx, i)) {
                path.add(String.valueOf(strs, idx, i - idx + 1));
                process(ans, path, strs, i + 1);
                path.remove(path.size() -  1);
            }
        }
    }
    public boolean isPalindrome(char[] strs, int begin, int end) {
        while (begin < end) {
            if (strs[begin++] != strs[end--]) {
                return false;
            }
        }
        return true;
    }
}
