package SwordOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @Description: 最长不含重复字符的子字符串
 * @Author: Marco
 * @Date: 2021-09-07 16:28
 **/

public class Offer048 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int maxLength = 1;
        int right = 1;
        for (int left = 0; left < len; left++) {
            if (left != 0) {
                set.remove(s.charAt(left - 1));
            }
            while (right < len && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }
}
