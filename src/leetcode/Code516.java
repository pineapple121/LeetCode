package leetcode;
//最长回文子序列

/**
 * if (s[i] == s[j])
 *     // 它俩一定在最长回文子序列中
 *     dp[i][j] = dp[i + 1][j - 1] + 2;
 * else
 *     // s[i+1..j] 和 s[i..j-1] 谁的回文子序列更长？
 *     dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
 *
 */
public class Code516 {
    public int longestPalindromeSubseq(String s) {
        int len=s.length();
        int[][] dp=new int[len][len];
        for(int i=len-1;i>=0;i--){
            dp[i][i]=1;
            for(int j=i+1;j<len;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
