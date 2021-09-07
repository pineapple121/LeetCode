package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 把数字翻译成字符串
 * @Author: Marco
 * @Date: 2021-09-01 15:41
 **/

public class Offer046 {
    //自己写的，使用动态规划，时间复杂度较高
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len + 1];
        //0个数字和1个数字都只有一种翻译方式
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            String value = "" + s.charAt(i - 2) + s.charAt(i - 1);
            int v = Integer.valueOf(value);
            if (v >= 10 && v <= 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }


    //优化后的dp，由于结果只跟前两个值有关，记录前两个值即可
    public int translateNum2(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
//        for (int i = s.length() - 2; i > -1; i--) {
//            String tmp = s.substring(i, i + 2);
//            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
//            b = a;
//            a = c;
//        }
        for (int i = 2; i <= s.length(); i++) {
            String value = s.substring(i - 2, i);
            int c = 0;
            if (value.compareTo("10") >= 0 && value.compareTo("25") <= 0) {
                c = a + b;
            } else {
                c = a;
            }
            b = a;
            a = c;
        }
        return a;
    }
}
