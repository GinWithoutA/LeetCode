# 算法导览

这里记录了 LeetCode 中写过的所有问题

## 1. 跟树有关的
### 1.1 二叉树遍历
#### 1.1.1 Morris 遍历

Morris 遍历利用了二叉树节点中空的**右孩子**指针，使其能够指向中序的后继节点，从而完成遍历

##### 具体题目：

-  [LeetCode_0094：二叉树的中序遍历](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0094_BinaryTreeInorderTraversal.java)

#### 1.1.2 普通的 DFS 或者 BFS遍历

##### 具体题目：

- [LeetCode_2415：反转二叉树的奇数层](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_2415_ReverseOddLevelsOfBinaryTree.java)

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

## 4. 集合

这些题目直接用系统自带的集合容器就可以解决，不用做太多其他的尝试

##### 具体题目：

- [LeetCode_0001：两数之和](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0001_TwoSum.java)
- [LeetCode_0015：三数之和](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0015_3Sum.java)
- [LeetCode_0023：合并 K 个有序链表](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0023_MergeKSortedList.java)
- [LeetCode_0056：合并重叠区间](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0056_MergeIntervals.java)
- [LeetCode_0128：最长连续序列](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0128_LongestConsecutiveSequence.java)
- [LeetCode_0202：快乐数](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0202_HappyNumber.java)
- [LeetCode_0205：同构字符串](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0205_IsomorphicStrings.java)
- [LeetCode_0219：存在重复元素Ⅱ](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0219_ContainsDuplicateII.java)
- [LeetCode_0242：有效的字母异位词](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0242_ValidAnagram.java)
- [LeetCode_0290：单词规律](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0290_WordPattern.java)

## 5. 字串子序列问题

字串子序列涉及到双指针，KMP，Mannacher，等等

##### 具体题目：

- [LeetCode_0003：最长不重复字串](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0003_LongestSubstringWithoutRepeatingCharacters.java)
- [LeetCode_0005：最长回文字串](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0005_LongestPalindromicSubstring.java)
- [LeetCode_0028：找出字符串中第一个匹配项的下标](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0028_FindTheIndexOfTheFirstOccurrenceInAString.java)


## 6. 双指针问题

一般是数组或者字符串问题，利用左右两个双指针可以得到最终的答案

##### 具体题目：

- [LeetCode_0011：能容纳的最大水量](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0011_ContainerWithMostWater.java)
- [LeetCode_0125：验证回文串](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0125_ValidPalindrome.java)
- [LeetCode_0167：两数之和Ⅱ输入有序数组](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0167_TwoSuIIInputArrayIsSorted.java)
- [LeetCode_0238：除自身以外数组的乘积](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0238_ProductOfArrayExceptSelf.java)
- [LeetCode_0392：验证子序列](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0392_IsSubsequence.java)

## 7. 通过分析过程就能够求解的问题

这类问题需要通过执行题目给定的流程，然后就能找到其中的规律，进行代码的编写

- [LeetCode_0068：文本左右对齐](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0068_TextJustification.java)
- [LeetCode_0289：生命游戏](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0289_GameOfLife.java)
- [LeetCode_1041：困于圆环中的机器人](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_1041_RobotBoundedInCircle.java)
- [LeetCode_1276：不浪费原料的汉堡制作方案](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_1276_NumberOfBurgersWithNoWasteOfIngredients.java)

## 8. 数组 / 字符串问题

- [LeetCode_0012：整数变成罗马数字](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0013_RomanToInteger.java)
- [LeetCode_0013：罗马数字转整数](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0013_RomanToInteger.java)
- [LeetCode_0014：最长公共前缀](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0014_LongestCommonPrefix.java)
- [LeetCode_0026：原地删除数组中的重复项](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0026_RemoveDuplicatesFromSortedArray.java)
- [LeetCode_0027：原地移除数组中的元素](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0027_RemoveElement.java)
- [LeetCode_0028：找出字符串中第一个匹配项的下标](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0028_FindTheIndexOfTheFirstOccurrenceInAString.java)
- [LeetCode_0042：接雨水问题](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0042_TrappingRainWater.java)
- [LeetCode_0045：跳跃游戏Ⅱ](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0045_JumpGameII.java)
- [LeetCode_0055：跳跃游戏](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0055_JumpGame.java)
- [LeetCode_0058：最后一个单词的长度](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0058_LengthOfLastWord.java)
- [LeetCode_0068：文本左右对齐](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0068_TextJustification.java)
- [LeetCode_0080：原地删除数组中的重复项Ⅱ](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0080_RemoveDuplicatesFromSortedArrayII.java)
- [LeetCode_0088：合并两个有序数组](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0088_MergeSortedArray.java)
- [LeetCode_0121：买卖股票的最佳时机](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0121_BestTimeToBuyAndSellStock.java)
- [LeetCode_0122：买卖股票的最佳时机Ⅱ](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0122_BestTimeToBuyAndSellStockII.java)
- [LeetCode_0134：加油站问题](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0134_GasStation.java)
- [LeetCode_0135：分发糖果问题](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0135_Candy.java)
- [LeetCode_0151：反转字符串中的单词](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0151_ReverseWordsInAString.java)
- [LeetCode_0169：找到数组中的多数元素](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0169_MajorityElement.java)
- [LeetCode_0189：轮转数组](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0189_RotateArray.java)
- [LeetCode_0274：H 指数](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0274_HIndex.java)
- [LeetCode_0380：O\(1\) 时间插入、删除和获取随机元素](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0380_InsertDeleteGetrandomO1.java)
- [LeetCode_0238：除自身以外数组的乘积](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0238_ProductOfArrayExceptSelf.java)
- [LeetCode_0383：赎金信](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0383_RansomNote.java)
- [LeetCode_2828：首字母缩略词](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_2828_CheckIfAStringIsAnAcronymOfWords.java)

## 9. 滑动窗口问题

通过滑动窗口解决

- [LeetCode_0003：最长不重复字串](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0003_LongestSubstringWithoutRepeatingCharacters.java)
- [LeetCode_0134：加油站问题](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0134_GasStation.java)
- [LeetCode_0209：长度最小的子数组](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0209_MinimumSizeSubarraySum.java)

## 10. 二分法

二分法不仅可以用于已经整理好数据的数组中，也可以用于一些有着特定规则的数组中

- [LeetCode_0162：寻找峰值](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0162_FindPeakElement.java)
- [LeetCode_1901：寻找峰值Ⅱ](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_1901_FindAPeakElementII.java)

## 11. 编码方式解决问题

这类问题大都不需要太多的算法技巧，都是考察的编码技巧就能解决

- [LeetCode_0001：两数之和](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0001_TwoSum.java)
- [LeetCode_0002：链表形式的两数之和](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0002_AddTwoNumbers.java)
- [LeetCode_0004：找到两个有序数组的中位数](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0004_MedianOfTwoSortedArrays.java)
- [LeetCode_0007：反转整数](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0007_ReverseInteger.java)
- [LeetCode_0036：有效的数独]()
- [LeetCode_0048：旋转图像]()
- [LeetCode_0054：螺旋矩阵]()
- [LeetCode_0073：矩阵置零](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0073_SetMatrixZeroes.java)
- [LeetCode_0228：合并区间](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0228_SummaryRanges.java)
- [LeetCode_0455：分发饼干](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0455_AssignCookies.java)
- [LeetCode_2706：购买两块巧克力](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_2706_BuyTwoChocolates.java)

## 12. LeetCode 周赛

### 第 373 周周赛

- [第一题：LeetCode_2946：循环移位后的矩阵相似检查](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_2946_MatrixSimilarityAfterCyclicShifts.java)

## 13. LeetCode 公司题

### (1) 高盛集团 Goldman Sachs

- [LeetCode_1041：困于圆环中的机器人](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_1041_RobotBoundedInCircle.java)
- 