package org.ginwithouta.leetcode;

import org.ginwithouta.leetcode.common.trie.Node;

/**
 * @author Ginwithouta
 * Generate at 2024/1/29
 * Problem 实现Trie（前缀树）
 */
public class Problem_0208_ImplementThePrefixTree {
    public static class Trie {
        public Node root;
        public Trie() {
            this.root = new Node();
        }
        public void insert(String word) {
            Node node = this.root;
            char[] strs = word.toCharArray();
            for (int i = 0; i < strs.length; ++i) {
                int idx = strs[i] - 'a';
                if (node.nexts[idx] == null) {
                    node.nexts[idx] = new Node();
                }
                node = node.nexts[idx];
                if (i == strs.length - 1) {
                    node.end = true;
                }
            }
        }

        public boolean search(String word) {
            /*
             * 只有到了最后一个字符，并且当前字符的 end 是 true 的时候，才表示找到了一个值
             */
            Node node = this.root;
            char[] strs = word.toCharArray();
            for (int i = 0; i < strs.length; ++i) {
                int idx = strs[i] - 'a';
                if (node.nexts[idx] == null) {
                    return false;
                }
                node = node.nexts[idx];
                if (i == strs.length - 1 && node.end) {
                    return true;
                }
            }
            return false;
        }

        public boolean startsWith(String prefix) {
            Node node = this.root;
            char[] strs = prefix.toCharArray();
            for (int i = 0; i < strs.length; ++i) {
                int idx = strs[i] - 'a';
                if (node.nexts[idx] == null) {
                    return false;
                }
                node = node.nexts[idx];
            }
            return true;
        }
    }
}
