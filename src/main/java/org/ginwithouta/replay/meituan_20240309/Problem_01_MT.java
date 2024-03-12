package org.ginwithouta.replay.meituan_20240309;

/**
 * @author Ginwithouta
 * Generate at 2024/3/9
 * 美团 春招 20240309 复盘 小美的MT
 */
public class Problem_01_MT {
    /**
     * 给定一个字符串，字符串中只包含大写字符，每次操作可以修改字符串中的一个字符，操作 K 次，求字符串中最多能够包含多少个 M 和 T
     */
    public int solve(String str, int k) {
        char[] strs = str.toCharArray();
        int count = 0;
        for (char c : strs) {
            if (c == 'M' || c == 'T') {
                ++count;
            } else if (k != 0) {
                ++count;
                --k;
            }
        }
        return count;
    }
}
