package org.ginwithouta.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/23
 * LeetCode Hot 100 括号生成
 */
public class LeetCode_Hot_059_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[n * 2];
        process(ans, path, 0, n, 0);
        return ans;
    }
    public void process(List<String> ans, char[] path, int leftPair, int n, int idx) {
        if (idx == path.length) {
            ans.add(String.valueOf(path));
            return;
        }
        if (n != 0) {
            path[idx] = '(';
            process(ans, path, leftPair + 1, n - 1, idx + 1);
        }
        if (leftPair != 0) {
            path[idx] = ')';
            process(ans, path, leftPair - 1, n, idx + 1);
        }
    }
}
