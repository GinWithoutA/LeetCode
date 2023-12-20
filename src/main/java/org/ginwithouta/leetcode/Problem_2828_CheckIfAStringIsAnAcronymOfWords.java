package org.ginwithouta.leetcode;

import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2023/12/20
 * Problem 判别首字母缩略词
 */
public class Problem_2828_CheckIfAStringIsAnAcronymOfWords {
    public boolean isAcronym(List<String> words, String s) {
        /*
         * 这题没什么好说的，直接做就是了
         */
        if (words.size() != s.length()) {
            return false;
        }
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; ++i) {
            if (words.get(i).charAt(0) != str[i]) {
                return false;
            }
        }
        return true;
    }
}
