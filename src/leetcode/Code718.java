package leetcode;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 思路1：动态规划
 */
public class Code718 {
//    //滑动窗口
//    public int findLength(int[] nums1, int[] nums2) {
//
//    }


    //动态规划，好理解，但是时间复杂度较高，为O(m*n);
//    public int findLength(int[] nums1, int[] nums2) {
//        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
//        int ans = 0;
//        for (int i = nums1.length - 1; i >= 0; i--) {
//            for (int j = nums2.length - 1; j >= 0; j--) {
//                if (nums1[i] == nums2[j]) {
//                    dp[i][j] = dp[i + 1][j + 1] + 1;
//                } else {
//                    dp[i][j] = 0;
//                }
//                ans = Math.max(ans, dp[i][j]);
//            }
//        }
//        return ans;
//    }
}
