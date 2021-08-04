package leetcode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 思路：用动态规划
 * 参考力扣答案
 */
public class Code005 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abc1234321ab"));
    }
    static String longestPalindrome(String s) {
        int n=s.length();
        boolean[][]dp=new boolean[n][n];
        String ans="";
        for(int length=0;length<n;length++){
            for(int i=0;i+length<n;i++){
                int j=i+length;
                if(length==0){
                    dp[i][j]=true;
                }else if(length==1){
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }else{
                    dp[i][j]=((s.charAt(i)==s.charAt(j))&& dp[i+1][j-1]);
                }
                if(dp[i][j] && length+1>ans.length()){
                    ans=s.substring(i,i+length+1);
                }
            }
        }
        return ans;
    }
}
