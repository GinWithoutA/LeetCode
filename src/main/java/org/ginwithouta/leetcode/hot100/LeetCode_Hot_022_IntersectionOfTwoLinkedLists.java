package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.ListNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/20
 * LeetCode Hot 100 相交链表
 */
public class LeetCode_Hot_022_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode top = headA, bot = headB;
        int topCount = 1, botCount = 1;
        while (top.next != null) {
            top = top.next;
            ++topCount;
        }
        while (bot.next != null) {
            bot = bot.next;
            ++botCount;
        }
        if (top != bot) {
            return null;
        }
        int big = Math.max(topCount, botCount), small = Math.min(topCount, botCount);
        top = big == topCount ? headA : headB;
        bot = top == headA ? headB : headA;
        while (big != small) {
            top = top.next;
            --big;
        }
        while (top != bot) {
            top = top.next;
            bot = bot.next;
        }
        return top;
    }
}
