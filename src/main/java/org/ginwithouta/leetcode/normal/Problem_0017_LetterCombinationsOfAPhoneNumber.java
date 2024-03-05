package org.ginwithouta.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/30
 * Problem 电话号码的字母组合
 */
public class Problem_0017_LetterCombinationsOfAPhoneNumber {
    private static final char[][] LETTERS_ = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'},      {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return ans;
        }
        char[] path = new char[digits.length()];
        process(ans, path, digits, 0);
        return ans;
    }
    public void process(List<String> ans, char[] path, String digits, int idx) {
        if (idx == digits.length()) {
            ans.add(String.valueOf(path));
        } else {
            for (char cur : LETTERS_[digits.charAt(idx) - 'a']) {
                path[idx] = cur;
                process(ans, path, digits, idx + 1);
            }
        }
    }
}
