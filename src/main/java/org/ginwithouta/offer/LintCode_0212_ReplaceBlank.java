package org.ginwithouta.offer;

/**
 * @author Ginwithouta
 * Generate at 2024/3/8
 * LintCode 剑指 Offer 空格替换
 */
public class LintCode_0212_ReplaceBlank {
    public int replaceBlank(char[] string, int length) {
        int count = 0;
        for (int i = 0; i < length; ++i) {
            if (string[i] == ' ') {
                ++count;
            }
        }
        int newLen = length + count * 2;
        for (int i = length - 1; i >= 0; --i) {
            if (string[i] == ' ') {
                string[i + count * 2] = '0';
                string[i + count * 2 - 1] = '2';
                string[i + count * 2 - 2] = '%';
                --count;
            } else {
                string[i + count * 2] = string[i];
            }
        }
        return newLen;
    }
}
