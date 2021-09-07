package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 连续子数组的最大和
 * @Author: Marco
 * @Date: 2021-09-01 10:03
 **/

public class Offer042 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxCount = nums[0];
        for (int a : nums) {
            pre = Math.max(pre + a, a);
            maxCount = Math.max(maxCount, pre);
        }
        return maxCount;
    }
}
