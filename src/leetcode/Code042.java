package leetcode;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Code042 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
//                ans+=Math.min(leftMax,rightMax)-height[left];
                ans += leftMax - height[left];

                left++;
            } else {
//                ans+=Math.min(leftMax,rightMax)-height[right];
                ans += rightMax - height[right];

                right--;
            }
        }
        return ans;
    }


    /**
     * 动态规划
     * 比上面的双指针好理解
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int length = height.length;
        if (length == 0) {
            return 0;
        }
        //leftMax数组用于记录当前位置左侧的最大高度
        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        //rightMax数组用于记录当前位置右侧的最大高度
        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        for (int j = length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        int ans = 0;
        //在某一位置处能接到的雨水，等于左右两边最大高度之间的较小值，减去当前位置的高度
        for (int i = 0; i < length; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
