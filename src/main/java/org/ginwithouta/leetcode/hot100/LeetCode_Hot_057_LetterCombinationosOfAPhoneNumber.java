package org.ginwithouta.leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/23
 * LeetCode Hot 100 电话号码的字母组合
 */
public class LeetCode_Hot_057_LetterCombinationosOfAPhoneNumber {

    private final char[][] letters = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isBlank()) {
            return ans;
        }
        char[] path = new char[digits.length()];
        process(ans, path, digits.toCharArray(), 0);
        return ans;
    }
    public void process(List<String> ans, char[] path, char[] digits, int index) {
        if (index == digits.length) {
            ans.add(String.valueOf(path));
            return;
        }
        int cur = digits[index] - '2';
        for (int i = 0; i < letters[cur].length; ++i) {
            path[index] = letters[cur][i];
            process(ans, path, digits, index + 1);
        }
    }
}
