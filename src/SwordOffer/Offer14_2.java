package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 剪绳子 II
 * @Author: Marco
 * @Date: 2021-08-23 21:54
 **/

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 注意：相比上一题，要多考虑大数越界问题，此时不能使用动态规划算法，因为取余过后，无法判断值 的大小
 * 思路：
 * 考虑贪心算法，将绳子先尽可能分成长度为3的子段
 */
public class Offer14_2 {
    public int cuttingRope(int n) {
        int mod = 1000000007;
        if (n < 4) {
            //1:0,2:1,3:2
            return n - 1;
        }
        long ans = 1;
        while (n > 4) {
            ans = ans * 3 % mod;
            n = n - 3;
        }
        ans = ans * n % mod;
        return (int) ans;
    }
}
