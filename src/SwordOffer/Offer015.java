package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 二进制中1的个数
 * @Author: Marco
 * @Date: 2021-08-24 10:05
 **/

public class Offer015 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) == 1) {
                ans++;
            }
        }
        return ans;
    }
}
