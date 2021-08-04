package leetcode;

/**
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 */
public class Code415 {
    public String addStrings(String num1, String num2) {
        int len1=num1.length();
        int len2=num2.length();
        int carry=0;
        StringBuilder ans=new StringBuilder();
        while(len1>0 || len2>0){
            char c1=len1>0?num1.charAt(len1-1):'0';
            char c2=len2>0?num2.charAt(len2-1):'0';
            int i=c1-'0';
            int j=c2-'0';
            int sum=i+j+carry;
            carry=sum/10;
            ans.append(sum%10);
            len1--;
            len2--;
        }
        if(carry!=0){
            ans.append(carry);
        }
        return ans.reverse().toString();
    }
}
