package org.ginwithouta.leetcode.interview150;

/**
 * @author Ginwithouta
 * Generate at 2024/3/29
 * LeetCode 面试经典 150 罗马数字转整数
 */
public class LeetCode_Interview_017_RomanToInteger {

    public int romanToInt(String s) {
        char[] str = s.toCharArray();
        int[] ans = new int[str.length];
        for (int i = 0; i < str.length; ++i) {
            switch (str[i]) {
                case 'I' :
                    ans[i] = 1;
                    break;
                case 'V' :
                    ans[i] = 5;
                    break;
                case 'X' :
                    ans[i] = 10;
                    break;
                case 'L' :
                    ans[i] = 50;
                    break;
                case 'C' :
                    ans[i] = 100;
                    break;
                case 'D' :
                    ans[i] = 500;
                    break;
                case 'M' :
                    ans[i] = 1000;
                    break;
                default:
                    break;
            }
        }
        int res = 0;
        for (int i = 0; i < ans.length - 1; ++i) {
            res += ans[i] < ans[i + 1] ? -ans[i] : ans[i];
        }
        return res + ans[ans.length - 1];
    }
}
