package org.ginwithouta.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/2/13
 * LintCode 剑指offer 0009 Fizz Buzz 问题
 */
public class LintCode_0009_FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("fizz buzz");
            } else if (i % 3 == 0) {
                ans.add("fizz");
            } else if (i % 5 == 0) {
                ans.add("buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}
