package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 1～n 整数中 1 出现的次数
 * @Author: Marco
 * @Date: 2021-09-01 10:22
 **/

//暴力法，超时
public class Offer043 {
    public int countDigitOne(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += getOneNumber(i);
        }
        return count;
    }

    public int getOneNumber(int n) {
        int ans = 0;
        while (n > 0) {
            int p = n % 10;
            if (p == 1) {
                ans++;
            }
            n = n / 10;
        }
        return ans;
    }
}