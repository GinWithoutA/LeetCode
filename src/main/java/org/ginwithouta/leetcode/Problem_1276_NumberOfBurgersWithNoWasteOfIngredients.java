package org.ginwithouta.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2023/12/25
 * Problem 不浪费原料的汉堡制作方案
 */
public class Problem_1276_NumberOfBurgersWithNoWasteOfIngredients {
    /**
     * 无脑做法
     */
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList<>(2);
        if ((tomatoSlices & 1) == 1 || Math.ceil(tomatoSlices / 4.0) > cheeseSlices) {
            return ans;
        }
        for (int big = cheeseSlices; big >= 0; --big) {
            int tomato = 4 * big + 2 * (cheeseSlices - big);
            if (tomato < tomatoSlices) {
                break;
            } else if (tomato == tomatoSlices) {
                ans.add(big);
                ans.add(cheeseSlices - big);
            }
        }
        return ans;
    }

    /**
     * 正常做法
     */
    public List<Integer> numOfBurgersBetter(int tomatoSlices, int cheeseSlices) {
        /*
         * 这题其实就是二元方程求解，再加上一些额外的判断就可以了
         */
        if ((tomatoSlices & 1) == 1 || tomatoSlices > cheeseSlices * 4) {
            return List.of();
        }
        if (tomatoSlices == 0 && cheeseSlices == 0) {
            return Arrays.asList(0, 0);
        }
        if (tomatoSlices == 0 || cheeseSlices == 0) {
            return List.of();
        }
        // tomatoSlices 和 cheeseSlices 的比例一定在 2 和 4 之间
        if (tomatoSlices / cheeseSlices < 2 || tomatoSlices / cheeseSlices > 4) {
            return List.of();
        }
        int big = tomatoSlices / 2 - cheeseSlices, small = cheeseSlices - big;
        if (small < 0 || big < 0) {
            return List.of();
        }
        if (big * 4 + small * 2 != tomatoSlices || big + small != cheeseSlices) {
            return List.of();
        }
        return Arrays.asList(big, small);
    }
}
