package leetcode;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 思路：利用动态规划，dp[i][j]表示子字符串i,j中无重复字符的最长子串长度
 *使用动态规划提示超出内存限制，因此只能使用滑动窗口的方法
 *
 */
public class Code003 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    //滑动窗口
    public static int lengthOfLongestSubstring(String s){
        int len=s.length();
        if(len==0)
            return 0;
        int ans=1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int right=1;
        for(int i=0;i<len;i++){
            if(i!=0){
                set.remove(s.charAt(i-1));

            }
            while(right<len && !set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }
            ans=Math.max(ans,right-i);
        }
        return ans;
    }


//用动态规划的方法超出内存限制
//    public static int lengthOfLongestSubstring(String s) {
//        if(s.length()==0){
//            return 0;
//        }
//        int maxLen=1;
//        int len=s.length();
//        int[][] dp=new int[len][len];
//        int i=0;
//        while(i<len){
//            for(int j=i;j<len;j++){
//                if(i==j){
//                    dp[i][j]=1;
//                    continue;
//                }
//                if(isInString(s.substring(i,j),s.charAt(j))){
//                    dp[i][j]=dp[i][j-1];
////                    i=j;
////                    j--;
//                    break;
//                }else{
//                    dp[i][j]=dp[i][j-1]+1;
//                    maxLen=Math.max(maxLen,dp[i][j]);
//
//                }
//            }
//            i++;
//        }
//        return maxLen;
//    }
//    public static boolean isInString(String s,char c){
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i)==c)
//                return true;
//        }
//        return false;
//    }
}
