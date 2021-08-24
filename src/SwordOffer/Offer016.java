package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 数值的整数次方
 * @Author: Marco
 * @Date: 2021-08-24 10:10
 **/

public class Offer016 {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double result = 1.0;
        double base = x;
        long times;
        if (n >= 0) {
            times = n;
        } else {
            times = -(long) n; // 如果是 -n ，由于 n 是 int 类型，因此 -n 超出取值范围，因此要先转为 long
        }

        while (times > 0) {
            if ((times & 1) == 1) result *= base;
            base *= base;
            times >>= 1;
        }
        return n >= 0 ? result : 1 / result;
    }
}
