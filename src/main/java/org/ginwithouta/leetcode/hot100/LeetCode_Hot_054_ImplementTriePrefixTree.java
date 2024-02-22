package org.ginwithouta.leetcode.hot100;

import org.ginwithouta.leetcode.common.trie.Node;
import org.ginwithouta.leetcode.common.trie.TreeNode;

/**
 * @author Ginwithouta
 * Generate at 2024/2/22
 * LeetCode Hot 100 实现Trie（前缀树）
 */
public class LeetCode_Hot_054_ImplementTriePrefixTree {
    public static class Trie {
        private TreeNode root;
        public Trie() {
            this.root = new TreeNode();
        }

        public void insert(String word) {
            char[] strs = word.toCharArray();
            TreeNode cur = this.root;
            for (char str : strs) {
                if (cur.nexts[str - 'a'] == null) {
                    cur.nexts[str - 'a'] = new TreeNode();
                }
                cur = cur.nexts[str - 'a'];
            }
            ++cur.end;
        }

        public boolean search(String word) {
            char[] strs = word.toCharArray();
            TreeNode cur = this.root;
            for (char str : strs) {
                if (cur.nexts[str - 'a'] == null) {
                    return false;
                }
                cur = cur.nexts[str - 'a'];
            }
            return cur.end > 0;
        }

        public boolean startsWith(String prefix) {
            char[] strs = prefix.toCharArray();
            TreeNode cur = this.root;
            for (char str : strs) {
                if (cur.nexts[str - 'a'] == null) {
                    return false;
                }
                cur = cur.nexts[str - 'a'];
            }
            return true;
        }
    }
}
