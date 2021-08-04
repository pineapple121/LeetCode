package leetcode;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 思路：
 * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 */
public class Code032 {
    //动态规划，考虑以s[i]结尾的字符串，那么仅当s[i]==')'时才是有效的，dp[i]才不为0
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int maxLength = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                /**
                 * 如果倒数第二个字符为')'，且其是有效括号字符子串subs的一部分，那么最后一个')'须在subs之前一位有匹配的'('才行
                 * dp[i-1]为subs的长度，加2为两个括号，dp[i - dp[i - 1] - 2]为subs之前的有效子串的长度
                 */
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
