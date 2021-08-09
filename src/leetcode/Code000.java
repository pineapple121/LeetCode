package leetcode;

/**
 * 这个类用于已经不止一次刷过的算法题，写出题解粘贴到力扣中
 */

public class Code000 {
    public String longestPalindrome(String s) {
        int len = s.length();
        String ans = "";
        boolean[][] dp = new boolean[len][len];
        for (int length = 0; length < len; length++) {
            for (int i = 0; i + length < len; i++) {
                int j = i + length;
                if (length == 0) {
                    dp[i][j] = true;
                } else if (length == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}
