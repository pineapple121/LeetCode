package leetcode;

/**
 * @program: LeetCode
 * @Description: 交错字符串
 * @Author: Marco
 * @Date: 2021-08-25 10:55
 **/

/**
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>
 * 思路：
 * 动态规划，假设三个字符串为s1，s2，s3，用数组dp[i][j]表示s1的前i个字符和s2的前j个字符能组成s3的前i+j个字符
 * 则dp[i][j]为true 的条件是:
 * 1.s1的前i-1个字符与s2 的前j个字符能组成s3 的前 i+j-1 个字符，且 s1[i]=s3[i+j]
 * 2.s1的前 i 个字符与s2的前 j-1 个字符能组成 s3 的前 i+j-1 个字符，且 s2[j]=s3[i+j]
 */
public class Code097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[len1][len2];
    }
}
