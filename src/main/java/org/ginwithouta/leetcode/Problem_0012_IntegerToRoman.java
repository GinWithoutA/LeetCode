package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/7
 * Problem 数字转罗马数字
 */
public class Problem_0012_IntegerToRoman {
    public String intToRoman(int num) {
        /*
         * 首先我们构建一个 0 - 9，10 - 90， ... 的对应表
         * 然后可以发现最高只有 3999 ，因此可以直接写四个 append 直接就能知道答案
         */
        String[][] match = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                            {"", "M", "MM", "MMM"}};
        StringBuilder sb = new StringBuilder();
        sb.append(match[3][num / 1000]);
        sb.append(match[2][num / 100 % 10]);
        sb.append(match[1][num / 10 % 10]);
        sb.append(match[0][num % 10]);
        return sb.toString();
    }
}
