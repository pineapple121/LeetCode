package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 打印从1到最大的n位数
 * @Author: Marco
 * @Date: 2021-08-24 10:48
 **/

public class Offer017 {
    public int[] printNumbers(int n) {
        int limit = 9;
        while (n > 1) {
            limit = limit * 10 + 9;
            n--;
        }
        int[] ans = new int[limit];
        for (int i = 0; i < limit; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
