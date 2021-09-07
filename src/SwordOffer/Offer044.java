package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 数字序列中某一位的数字
 * @Author: Marco
 * @Date: 2021-09-07 11:01
 **/

public class Offer044 {
    public int findNthDigit(int n) {
        //初始数字位数为1
        int digit = 1;
        //1位数字开始为1
        long start = 1;
        //1位的数字有9个
        long count = 9;
        while (n > count) {
            n -= count;
            digit++;
            start = start * 10;
            count = digit * start * 9;
        }
        //所求的位在哪一个数字
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

}
