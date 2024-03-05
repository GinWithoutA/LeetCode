package org.ginwithouta.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2023/12/28
 * Problem 快乐数
 */
public class Problem_0202_HappyNumber {
    public boolean isHappy(int n) {
        /*
         * 为了防止重复，我们需要一个额外的集合来存储中间出现过的所有数字，如果出现了重复数字，
         * 那么就说明当前数不是快乐数
         */
        List<Integer> list = new ArrayList<>();
        while (n != 1) {
            int sum = 0;
            while (n != 0) {
                int help = n % 10;
                sum += (help * help);
                n /= 10;
            }
            if (list.contains(sum)) {
                return false;
            }
            list.add(sum);
            n = sum;
        }
        return true;
    }
}
