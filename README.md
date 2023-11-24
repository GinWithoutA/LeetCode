# 算法导览

这里记录了 LeetCode 中写过的所有问题

## 1. 跟树有关的
### 1.1 二叉树遍历
#### 1.1.1 Morris 遍历

Morris 遍历利用了二叉树节点中空的**右孩子**指针，使其能够指向中序的后继节点，从而完成遍历

##### 具体题目：

-  [LeetCode_0094：二叉树的中序遍历](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0094_BinaryTreeInorderTraversal.java)

## 2. 从暴力递归到动态规划

动态规划的开始都是从暴力递归的尝试开启的，只要能够找到合适的暴力递归的书写流程，那么就能够改成动态规划<br>

<br>这里面一般有四种模型：

1. 从左到右的尝试模型
2. 样本模型
3. 范围尝试模型
4. 业务限制模型

并不是说这四种模型区分度很高，有时候可以互相变通

### 2.1 范围尝试模型
范围禅师模型注重范围的开始和结束，也就是开始怎样怎样，结尾怎样怎样，抓住这个要点，下手暴力递归
##### 具体题目：

- [LeetCode_0516：字符串中的最长回文子序列](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Probelm_0516_LongestPalindromicSubsequence.java)

## 3. 荷兰国旗问题

荷兰国旗是一种经典的解决某些问题的方式，例如求数组中的第几大的数。它将一堆数据可以以一个关键字划分为以这个关键字，相等的在中间，小于
在左边，大于在右边

##### 具体题目：

- [LeetCode_0215：找到数组中最大的第 k 个数](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0215_KthLargestElementInAnArray.java)

## 10. 其他的一些题

- [LeetCode_0455：分发饼干](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0455_AssignCookies.java)
- [LeetCode_0001：两数之和](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0001_TwoSum.java)
- [LeetCode_0015：三数之和](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0015_3Sum.java)