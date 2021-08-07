package leetcode;
/**
 * 这个类用于已经不止一次刷过的算法题，写出题解粘贴到力扣中
 */

import java.util.HashSet;
import java.util.Set;

public class Code000 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return -1;
        }
        int sLen = s.length();
        if (sLen == 0 || sLen == 1) {
            return sLen;
        }
        Set<Character> set = new HashSet<>();
        int right = 1;
        int maxLength = 1;
        set.add(s.charAt(0));
        for (int left = 0; left < s.length(); left++) {
            if (left != 0) {
                set.remove(s.charAt(left - 1));
            }
            while (right < sLen && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
