package leetcode;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 思路：动态规划
 * f(i)=max{f(i−1)+nums[i],nums[i]}
 */
public class Code053 {
        public int maxSubArray(int[] nums) {
            //由于转移方程中，f(i)只和f(i-1)有关，因此可以只用一个变量保存f(i-1)即可，O(1)的空间复杂度
            int pre=0;
            int maxValue=nums[0];
            for(int x:nums){
                pre=Math.max(pre+x,x);
                maxValue=Math.max(maxValue,pre);
            }
            return maxValue;
        }
    //需要用到O(n)的空间复杂度
//    public int maxSubArray(int[] nums) {
//        if(nums==null || nums.length==0){
//            throw new NullPointerException();
//        }
//        int []dp=new int[nums.length];
//        dp[0]=nums[0];
//        for(int i=1;i<nums.length;i++){
//            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
//        }
//        int ans=dp[0];
//        for(int i=0;i<nums.length;i++){
//            ans=Math.max(dp[i],ans);
//        }
//        return ans;
//    }
}
