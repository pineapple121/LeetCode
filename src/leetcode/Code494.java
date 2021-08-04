package leetcode;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 *
 * dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
 */
public class Code494 {
    public static void main(String[] args) {
        int[] nums=new int[]{1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums,3));
    }
    public static int findTargetSumWays(int[] nums, int S) {
        int len=nums.length;
        int sum=0;
        for(int i=0;i<len;i++){
            sum+=nums[i];
        }
        //上边界
        int t=sum*2+1;
        int[][] dp = new int[len][t];
        //初始化
        //因数组下标不能为负，将sum视为原点
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }
        for(int i=1;i<len;i++){
            for(int j=0;j<t;j++){
                // 边界
                int l = (j - nums[i]) >= 0 ? j - nums[i] : 0;
                int r = (j + nums[i]) < t ? j + nums[i] : 0;
                dp[i][j]=dp[i-1][l]+dp[i-1][r];

            }
//            for(int j=0;j<sum;j++){
//                dp[i][j]=dp[i-1][j-nums[i]+sum]+dp[i-1][j+nums[i]+sum];
//            }
        }
        return S > sum ? 0 : dp[len - 1][S + sum];
    }
}
