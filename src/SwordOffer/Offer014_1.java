package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 剪绳子
 * @Author: Marco
 * @Date: 2021-08-23 21:18
 **/

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路：
 * 动态规划，用dp[i]表示长度为i的绳子剪成m段后的最大乘积
 * 初始值dp[2]=1;
 * 对于长度为i的绳子，假设减去的第一段长为j,则剩下的（i-j）长度的绳子，可以剪，可以不剪，剪的话，则求j*dp[i-j]，不剪的话，则为j*(i-j)
 * 第一次减去的长度取值为：2<=j<i;dp[i]应对所有的情况求出最大值
 */
public class Offer014_1 {
    public int cuttingRope(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
