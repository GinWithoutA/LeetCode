package org.ginwithouta.leetcode.company.meituan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ginwithouta
 * Generate at 2024/3/8
 * LeetCode 美团 复原IP地址
 */
public class LeetCode_Meituan_003_RestoreIPAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 4) {
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        process(s, ans, path, 0);
        return ans;
    }
    public void process(String str, List<String> ans, List<Integer> path, int idx) {
        if (idx == str.length()) {
            if (path.size() != 4) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); ++i) {
                sb.append(path.get(i));
                if (i != path.size() - 1) {
                    sb.append(".");
                }
            }
            ans.add(sb.toString());
            return;
        }
        if (str.charAt(idx) == '0') {
            path.add(0);
            process(str, ans, path, idx + 1);
            path.remove(path.size() - 1);
            return;
        }
        for (int i = 1; i < 4 && idx + i <= str.length(); ++i) {
            int res = Integer.parseInt(str.substring(idx, idx + i));
            if (res >= 0 && res <= 255) {
                path.add(res);
                process(str, ans, path, idx + i);
                path.remove(path.size() - 1);
            }
        }
    }
}
