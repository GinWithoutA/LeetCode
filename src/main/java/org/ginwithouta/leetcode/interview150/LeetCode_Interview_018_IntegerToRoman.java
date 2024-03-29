package org.ginwithouta.leetcode.interview150;


/**
 * @author Ginwithouta
 * Generate at 2024/3/29
 * LeetCode 面试经典 150 整数转罗马数字
 */
public class LeetCode_Interview_018_IntegerToRoman {
    public String[][] map = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}
    };
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        sb.append(map[3][num / 1000]);
        sb.append(map[2][num / 100 % 10]);
        sb.append(map[1][num / 10 % 10]);
        sb.append(map[0][num % 10]);
        return sb.toString();
    }
}
