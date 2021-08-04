package leetcode;

/**
 * 42. 接雨水
 *
 */
public class Code042 {
    public int trap(int[] height) {
        int left=0,right=height.length-1;
        int leftMax=0,rightMax=0;
        int ans=0;
        while(left<right){
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);
            if(height[left]<height[right]){
//                ans+=Math.min(leftMax,rightMax)-height[left];
                ans+=leftMax-height[left];

                left++;
            }else{
//                ans+=Math.min(leftMax,rightMax)-height[right];
                ans+=rightMax-height[right];

                right--;
            }
        }
        return ans;
    }
}
