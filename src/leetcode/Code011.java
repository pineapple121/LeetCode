package leetcode;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 暴力破解，两层嵌套循环，找到面积最大的长方形
 */
public class Code011 {
    public static void main(String[] args) {
        Solution11 s11=new Solution11();
        int[] height=new int[]{1,1};
        System.out.println(s11.maxArea(height));
    }
}
class Solution11 {
    public int maxArea(int[] height) {
        int length=height.length;
        int maxWater=0;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                int water=(j-i)*Math.min(height[i],height[j]);
                maxWater=Math.max(maxWater,water);
            }
        }
        return maxWater;
    }
}