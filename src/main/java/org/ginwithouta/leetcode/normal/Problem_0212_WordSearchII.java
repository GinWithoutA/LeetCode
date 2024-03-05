package org.ginwithouta.leetcode.normal;

import org.ginwithouta.leetcode.common.trie.TreeNode;

import java.util.*;

/**
 * @author Ginwithouta
 * Generate at 2024/1/29
 * Problem 单词搜索Ⅱ
 */
public class Problem_0212_WordSearchII {
    public static class TrieTree{
        public TreeNode root;
        public TrieTree() {
            this.root = new TreeNode();
        }
    }
    public TrieTree build(String[] words) {
        TrieTree trieTree = new TrieTree();
        Set<String> set = new HashSet<>();
        for (String word : words) {
            if (set.contains(word)) {
                continue;
            }
            set.add(word);
            TreeNode node = trieTree.root;
            ++node.pass;
            char[] strs = word.toCharArray();
            for (char str : strs) {
                int idx = str - 'a';
                if (node.nexts[idx] == null) {
                    node.nexts[idx] = new TreeNode();
                }
                node = node.nexts[idx];
                ++node.pass;
            }
            ++node.end;
        }
        return trieTree;
    }

    public List<String> findWords(char[][] board, String[] words) {
        /*
         * 基本的思路可以用一个前缀树先构建 words ，然后我们遍历 board。每次遍历的过程中，我们需要知道下层
         * 的遍历解决了多少单词，这个解决的数量需要减去当前的 pass。在递归的时候，如果发现 pass == 0，就说明
         * 下面已经解决过了
         */
        TrieTree tree = this.build(words);
        List<String> ans = new ArrayList<>();
        LinkedList<Character> path = new LinkedList<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                this.process(board, tree.root, ans, path, 0, 0);
            }
        }
        return ans;
    }

    public int process(char[][] board, TreeNode node, List<String> ans, LinkedList<Character> path, int row, int col) {
        if (board[row][col] == '0') {
            return 0;
        }
        char curChar = board[row][col];
        TreeNode curNode = node.nexts[curChar - 'a'];
        if (curNode == null || curNode.pass == 0) {
            return 0;
        }
        board[row][col] = '0';
        int solved = 0;
        path.addLast(curChar);
        if (curNode.end > 0) {
            --curNode.end;
            ++solved;
            this.add(ans, path);
        }
        if (row + 1 < board.length) {
            solved += process(board, curNode, ans, path, row + 1, col);
        }
        if (row - 1 < board[0].length) {
            solved += process(board, curNode, ans, path, row - 1, col);
        }
        if (col + 1 < board.length) {
            solved += process(board, curNode, ans, path, row, col + 1);
        }
        if (col - 1 < board.length) {
            solved += process(board, curNode, ans, path, row, col - 1);
        }
        board[row][col] = curChar;
        path.pollLast();
        curNode.pass -= solved;
        return solved;
    }

    public void add(List<String> ans, LinkedList<Character> path) {
        StringBuilder sb = new StringBuilder();
        path.forEach(sb::append);
        ans.add(sb.toString());
    }
}
