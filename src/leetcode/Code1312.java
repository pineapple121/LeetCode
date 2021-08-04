package leetcode;

/**
 * 让字符串成为回文串的最少插入次数
 *
 * 思路：
 * 我们需要在原字符串 s 中找到一个最长回文子序列，若其长度为 l，那么我们只需要添加 |s| - l 个字符，就可以将 s 变为回文串
 */
public class Code1312 {
    public int minInsertions(String s) {
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
        return len-dp[0][len-1];
    }
}
