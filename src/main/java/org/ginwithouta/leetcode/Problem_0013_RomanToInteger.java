package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/7
 */
public class Problem_0013_RomanToInteger {

    public int romanToInt(String s) {
        /*
         * 题目中有一个关键点，就是数字都是大的在前，小的在后，只有几种情况除外
         * 因此我们就正常记录每个位置的值，然后如果碰到后面的值小于前面的值，就
         * 说明后面的值需要减去前面的值再加，也就是直接加一个负数值
         */
        char[] str = s.toCharArray();
        int[] num = new int[str.length];
        for (int i = 0; i < str.length; ++i) {
            switch (str[i]) {
                case 'I':
                    num[i] = 1;
                    break;
                case 'V':
                    num[i] = 5;
                    break;
                case 'X':
                    num[i] = 10;
                    break;
                case 'L':
                    num[i] = 50;
                    break;
                case 'C':
                    num[i] = 100;
                    break;
                case 'D':
                    num[i] = 500;
                    break;
                case 'M':
                    num[i] = 1000;
                    break;
                default:
                    break;
            }
        }
        int res = 0;
        for (int i = 0; i < num.length - 1; ++i) {
            res += num[i] < num[i + 1] ? -num[i] : num[i];
        }
        return res + num[num.length - 1];
    }
}
