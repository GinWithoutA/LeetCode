package org.ginwithouta.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/1/25
 * problem 计算 K 位置下标对应元素的和
 */
public class Problem_2859_SumOfValuesAtIndicesWithKSetBits {
    public int sumindicesWithKSetBits(List<Integer> nums, int k) {
        /*
         * 除去内置函数 Integer.bitCount() 有两种计算二进制中有多少个 1 的方法
         *
         */
        int ans = 0;
        for (int i = 0; i < nums.size(); ++i) {
            int temp = i, count = 0;
            while (temp != 0) {
                count += temp & 1;
                temp >>>= 1;
            }
            if (count == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }

    public int method(List<Integer> nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.size(); ++i) {
            int temp = i, count = 0;
            while (temp != 0) {
                temp &= (temp - 1);
                ++count;
            }
            if (count == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }
}
