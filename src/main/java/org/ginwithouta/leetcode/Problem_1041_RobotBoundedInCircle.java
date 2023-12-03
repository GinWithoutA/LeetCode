package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/3
 * Problem 困在圆环之中的机器人
 */
public class Problem_1041_RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        /*
         * 这题的关键点在于：每次执行都是重复的操作，那么我们可以进行分析：
         *  1）如果执行完一次轨迹，机器人还在原点，那么不管执行多少次，他都会回到原点
         *  2）如果执行完一次轨迹，机器人不在原点：
         *      1. 如果此时机器人朝向北，由于操作重复，再执行一次也不会到现在这个点，并且也还是朝向北边
         *      2. 如果此时机器人朝向南，由于操作重复，再执行一次他会变成回到原点，然后朝向北，将永远无法逃离
         *      3. 如果此时机器人朝向西，那么下一次执行他将朝向南，然后朝向东，然后朝向北，回到原点
         *      4. 如果此时机器人朝向东，和上面一样
         */
        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int direction = 1, x = 0, y = 0;
        for (char str : instructions.toCharArray()) {
            switch (str) {
                case 'G':
                    x += move[direction][0];
                    y += move[direction][1];
                    break;
                case 'L':
                    direction = (direction - 1) == -1 ? 3 : direction - 1;
                    break;
                case 'R':
                    direction = (direction + 1) % 4;
                    break;
                default:
                    break;
            }
        }
        if (x == 0 && y == 0) {
            return true;
        } else {
            return direction != 1;
        }
    }
}
