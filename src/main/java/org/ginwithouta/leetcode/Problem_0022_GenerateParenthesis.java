package org.ginwithouta.leetcode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/31
 * Problem 括号生成
 */
public class Problem_0022_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        /*
         * 关键在于我们要知道前面给了多少个 ( ,还剩多少个需要匹配的
         * 因此定义两个变量 leftPair 表示当前需要匹配的数量, leftNum 表示还要匹配多少个括号对
         */
        List<String> ans = new ArrayList<>();
        char[] path = new char[n << 1];
        process(ans, path, 0, n, 0);
        return ans;
    }
    public void process(List<String> ans, char[] path, int leftPair, int leftNum, int idx) {
        /*
         * 每一次递归都有两种选择
         * 1）加一个 (
         * 2）匹配一个 (
         */
        if (idx == path.length) {
            ans.add(String.valueOf(path));
            return;
        }
        if (leftNum > 0) {
            path[idx] = '(';
            process(ans, path, leftPair + 1, leftNum - 1, idx + 1);
        }
        if (leftPair > 0) {
            path[idx] = ')';
            process(ans, path, leftPair - 1, leftNum, idx + 1);
        }
    }
}
