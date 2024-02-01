# 算法导览

这里记录了 LeetCode 中写过的所有问题

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

- [LeetCode_0056：插入区间](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0056_MergeIntervals.java)
- [LeetCode_0068：文本左右对齐](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0068_TextJustification.java)
- [LeetCode_0289：生命游戏](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0289_GameOfLife.java)
- [LeetCode_1041：困于圆环中的机器人](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_1041_RobotBoundedInCircle.java)
- [LeetCode_1185：一周之中的第几天](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_1185_DayOfTheWeek.java)
- [LeetCode_1276：不浪费原料的汉堡制作方案](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_1276_NumberOfBurgersWithNoWasteOfIngredients.java)
- [LeetCode_1599：经营摩天轮的最大利润](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_1599_MaximumProfitOfOperatingACentennialWheel.java)
- [LeetCode_2788：按分隔符拆分字符串数组](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_2788_SplitStringsBySeparator.java)

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
- [LeetCode_2808：使循环数组所有元素相等的最少秒数](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_2808_MinimumSecondsToEqualizeACircularArray.java)
- [LeetCode_2828：首字母缩略词](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_2828_CheckIfAStringIsAnAcronymOfWords.java)
- [LeetCode_2859：计算 K 位置下标对应元素的和](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_2859_SumOfValuesAtIndicesWithKSetBits.java)

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
- [LeetCode_0036：有效的数独](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0036_ValidSudoku.java)
- [LeetCode_0048：旋转图像](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0048_RotateImage.java)
- [LeetCode_0054：螺旋矩阵](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0054_SpiralMatrix.java)
- [LeetCode_0073：矩阵置零](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0073_SetMatrixZeroes.java)
- [LeetCode_0228：合并区间](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0228_SummaryRanges.java)
- [LeetCode_0455：分发饼干](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0455_AssignCookies.java)
- [LeetCode_2706：购买两块巧克力](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_2706_BuyTwoChocolates.java)

## 12. 思路转化

这类问题如果直直的做，很难做出来，但如果根据给定数据的特殊性以及测试样本的特殊性入手，就可以完成

##### 具体题目：
- [LeetCode_2397：被列覆盖的最多行数](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_2397_MaximumRowsCoveredByColumns.java)
- [LeetCode_0452：用最少数量的箭引爆气球](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0452_MinimumNumberOfArrowsToBurstBalloons.java)

## 13. LeetCode 周赛

### 第 373 周周赛

- [第一题：LeetCode_2946：循环移位后的矩阵相似检查](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_2946_MatrixSimilarityAfterCyclicShifts.java)

## 14. LeetCode 公司题

### (1) 高盛集团 Goldman Sachs

- [LeetCode_1041：困于圆环中的机器人](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_1041_RobotBoundedInCircle.java)

## 15. 数据结构
### （1）栈
##### 具体题目：
- [LeetCode_0020：括号匹配](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0020_ValidParentheses.java)
- [LeetCode_0071：简化路径](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0071_SimplifyPath.java)
- [LeetCode_0150：逆波兰表达式求值](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0150_EvaluateReversePolishNotation.java)
- [LeetCode_0155：最小栈](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0155_MinStack.java)
- [LeetCode_0224：基本计算器](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0224_BasicCalculator.java)
- [LeetCode_2865：美丽塔Ⅰ](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_2865_BeautifulTowersI.java)
### （2）链表
##### 具体题目：
- [LeetCode_0019：删除链表的倒数第 N 个结点](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0019_RemoveNthNodeFromEndOfList.java)
- [LeetCode_0021：合并两个有序链表](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0021_MergeTwoSortedLists.java)
- [LeetCode_0061：旋转链表](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0061_RotateList.java)
- [LeetCode_0025：K组一个翻转链表](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0025_ReverseNodesInKGroup.java)
- [LeetCode_0082：删除链表中的重复元素Ⅱ](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0082_RemoveDuplicatesFromSortedListII.java)
- [LeetCode_0086：分割链表](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0086_PartitionList.java)
- [LeetCode_0092：反转链表Ⅱ](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0092_ReverseLinkedListII.java)
- [LeetCode_0138：随机链表的复制](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0138_CopyListWithRandomPointer.java)
- [LeetCode_0141：环形链表](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0141_LinkedListCycle.java)
- [LeetCode_0146：LRU缓存](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0146_LRUCache.java)
### （2）树
#### （2.1）二叉树
##### 具体题目
- [LeetCode_0100：相同的树](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0100_SameTree.java)
- [LeetCode_0101：对称二叉树](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0101_SymmetricTree.java)
- [LeetCode_0104：二叉树的最大深度](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0104_MaximumDepthOfBinaryTree.java)
- [LeetCode_0105：从前序与中序遍历序列构造二叉树](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0105_ConstructBinaryTreeFromPreorderAndInorderTraversal.java)
- [LeetCode_0106：从后续与中序遍历序列构造二叉树](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0106_ConstructBinaryTreeFromInorderAndPostorderTraversal.java)
- [LeetCode_0112：路径总和](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0112_PathSum.java)
- [LeetCode_0114：二叉树展开成链表](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0114_FlattenBinaryTreeToLinkedList.java)
- [LeetCode_0117：填充每个节点的下一个右侧节点指针Ⅱ](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0117_PopulatingNextRightPointersInEachNodeII.java)
- [LeetCode_0124：二叉树中的最大路径和](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0124_BinaryTreeMaximumPathSum.java)
- [LeetCode_0129：求根节点到叶节点数字之和](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0129_SumRootToLeafNumbers.java)
- [LeetCode_0173：二叉搜索迭代器](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0173_BinarySearchTreeIterator.java)
- [LeetCode_0222：完全二叉树节点的个数](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0222_CountCompleteTreeNodes.java)
- [LeetCode_0226：反转二叉树](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0226_InvertBinaryTree.java)
- [LeetCode_0236：二叉树的最近公共祖先](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0236_LowestCommonAncestorOfABinaryTree.java)
- [LeetCode_2415：反转二叉树的奇数层](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_2415_ReverseOddLevelsOfBinaryTree.java)
#### （2.2）二叉树层次遍历
##### 具体题目
- [LeetCode_0199：二叉树的右视图](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0199_BinaryTreeRightSideView.java)
- [LeetCode_0102：二叉树层次遍历](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0102_BinaryTreeLevelOrderTraversal.java)
- [LeetCode_0103：二叉树的锯齿形层序遍历](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0103_BinaryTreeZigzagLevelOrderTraversal.java)
- [LeetCode_0637：二叉树的层平均值](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0637_AverageOfLevelsInBinaryTree.java)
#### （2.3）二叉搜索树
##### 具体题目
- [LeetCode_0098：验证二叉搜索树](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0098_ValidateBinarySearchTree.java)
- [LeetCode_0230：二叉搜索树中第 k 小的元素](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0230_KthSmallestElementInABST.java)
- [LeetCode_0530：二叉搜索树的最小绝对差](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0530_MinimumAbsoluteDifferrenceInBst.java)
--------------------------------------------------------------------------------
**Morris 遍历**
<br>Morris 遍历利用了二叉树节点中空的**右孩子**指针，使其能够指向中序的后继节点，从而完成遍历
-  [LeetCode_0094：二叉树的中序遍历](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0094_BinaryTreeInorderTraversal.java)
--------------------------------------------------------------------------------
####（2.4）字典树
##### 具体题目
- [LeetCode_0208：构建前缀树](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0208_ImplementThePrefixTree.java)
- [LeetCode_0212：单词搜索](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0212_WordSearchII.java)
## 16. 图
##### 具体题目
- [LeetCode_0130：被围绕的区域](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0130_SurroundedRegions.java)
- [LeetCode_0133：克隆图](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0133_CloneGraph.java)
- [LeetCode_0200：岛屿数量](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0200_NumberOfIslands.java)
- [LeetCode_0200：岛屿数量（并查集版本）](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0200_NumberOfIslands_UnionSet.java)
- [LeetCode_0200：岛屿数量（优化的并查集版本）](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0200_NumberOfIslands_UnionSet_better.java)
- [LeetCode_0207：课程表](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0207_CourseSchedule.java)
- [LeetCode_0210：课程表Ⅱ](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0210_CourseScheduleII.java)
## 17. 回溯
- [LeetCode_0017：电话号码的字母组合](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0017_LetterCombinationsOfAPhoneNumber.java)
- [LeetCode_0022：括号匹配](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0022_GenerateParenthesis.java)
- [LeetCode_0039：组合总和](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0039_CombinationSum.java)
- [LeetCode_0046：全排列](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0046_Permutations.java)
- [LeetCode_0051：N皇后](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0051_NQueens.java)
- [LeetCode_0052：N皇后Ⅱ](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0052_NQueensII.java)
- [LeetCode_0077：组合](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0077_Combinations.java)
- [LeetCode_0079：单词搜索](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0079_WordSearch.java)
## 18. 分治
##### 具体题目
- [LeetCode_0108：将有序数组转换为二叉搜索树](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0108_ConvertSortedArrayToBinarySearchTree.java)
- [LeetCode_0148：排序链表](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0148_SortList.java)
- [LeetCode_0427：建立四叉树](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0427_ConstructQuadTree.java)
## 19. 数字
##### 具体数字
- [LeetCode_0009：回文数](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0009_PalindromeNumber.java)
- [LeetCode_0066：加一](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0066_PlusOne.java)
- [LeetCode_0172：阶乘后的零](https://github.com/GinWithoutA/LeetCode/blob/main/src/main/java/org/ginwithouta/leetcode/Problem_0172_FactorialTrailingZeroes.java)