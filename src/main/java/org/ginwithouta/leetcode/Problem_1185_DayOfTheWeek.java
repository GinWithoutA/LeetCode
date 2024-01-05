package org.ginwithouta.leetcode;

/**
 * @author Ginwithouta
 * Generate at 2023/12/30
 * Problem 一周中的第几天
 */
public class Problem_1185_DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        /*
         * 题目规定输入的日期一定是在 197119711971 到 210021002100 年之间的有效日期，即在 197119711971 年 111 月 111 日，到 210021002100 年 121212 月 313131 日之间。通过查询日历可知，197019701970 年 121212 月 313131 日是星期四，我们只需要算出输入的日期距离 197019701970 年 121212 月 313131 日有几天，再加上 333 后对 777 求余，即可得到输入日期是一周中的第几天。
         *
         * 求输入的日期距离 197019701970 年 121212 月 313131 日的天数，可以分为三部分分别计算后求和：
         *
         *   （1）输入年份之前的年份的天数贡献；
         *   （2）输入年份中，输入月份之前的月份的天数贡献；
         *   （3）输入月份中的天数贡献。
         *
         * 例如，如果输入是 210021002100 年 121212 月 313131 日，即可分为三部分分别计算后求和：
         *
         *   （1）197119711971 年 111 月 111 到 209920992099 年 121212 月 313131 日之间所有的天数；
         *   （2）210021002100 年 111 月 111 日到 210021002100 年 111111 月 313131 日之间所有的天数；
         *   （3）210021002100 年 121212 月 111 日到 210021002100 年 121212 月 313131 日之间所有的天数。
         *
         * 其中（1）和（2）部分的计算需要考虑到闰年的影响。当年份是 400400400 的倍数或者是 444 的倍数且不是 100100100 的倍数时，该年会在二月份多出一天。
         */
        String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        int days = 365 * (year - 1971) + (year - 1969) / 4;
        for (int i = 0; i < month - 1; ++i) {
            days += monthDays[i];
        }
        // 如果是闰年
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            days += 1;
        }
        days += day;
        return weeks[(days + 3) % 7];
    }
}