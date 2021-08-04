package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 */
public class Code093 {
    List<String> ans;
    int[] segments;

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        segments = new int[4];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segmentId, int start) {
        if (segmentId == 4 && start == s.length()) {
            StringBuilder ipAddr = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                ipAddr.append(segments[i]);
                if (i != 3) {
                    ipAddr.append('.');
                }
            }
            ans.add(ipAddr.toString());
        }
        if (segmentId == 4 || start == s.length())
            return;
        
        if (s.charAt(start) == '0') {
            segments[segmentId] = 0;
            dfs(s, segmentId + 1, start + 1);
        }

        int addr = 0;
        for (int segEnd = start; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segmentId] = addr;
                dfs(s, segmentId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
