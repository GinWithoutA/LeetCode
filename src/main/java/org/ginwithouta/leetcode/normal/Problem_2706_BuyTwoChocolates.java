package org.ginwithouta.leetcode.normal;

import java.util.Arrays;

/**
 * @author Ginwithouta
 * Generate at 2023/12/29
 * Problem 购买两块巧克力
 */
public class Problem_2706_BuyTwoChocolates {
    /**
     * 自己想的解法
     */
    public int buyChoco(int[] prices, int money) {
        /*
         * 排序之后，只需要判断前两个元素是否满足要求
         */
        Arrays.sort(prices);
        if (prices[0] + prices[1] > money) return money;
        return money - prices[0] - prices[1];
    }

    /**
     * 最优解
     */
    public int butChocoAnother(int[] prices, int money) {
        /*
         * 上面排序的方法就是有很多不必要的工作，例如交换等等，我们只需要找到第一小和第二小的两个元素即可
         * 要注意在更新第一小的数的时候，如果当前数小于第一小的数，由于第一小的数一定小于第二小的数，因此
         * 更新前需要将当前第一小的数给第二小，然后更新第一小
         */
        int one = 101, two = 101;
        for (int price : prices) {
            if (price < one) {
                two = one;
                one = price;
            } else if (price < two) {
                two = price;
            }
        }
        return one + two > money ? money : money - one - two;
    }
}
