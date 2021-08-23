package leetcode;

/**
 * @program: LeetCode
 * @Description: 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * @Author: Marco
 * @Date: 2021-08-11 15:33
 **/

/**
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */

public class Code072 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //dp[i][j]存储以i结尾的word1的子串和以j结尾的word2的子串，变成相同的字符串所需的最少操作数
        int[][] dp = new int[m + 1][n + 1];
        //初始化dp
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //word1[i-1],word2[j-1]不同，word1添加上第i个，word2添加上第j个，需要修改一次,因此dp[i - 1][j - 1] + 1
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
                //相同，添加后不需要再额外修改一次了,因此dp[i - 1][j - 1]
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
