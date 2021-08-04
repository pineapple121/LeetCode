package leetcode;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 思路：
 * 考虑最后一个元素为x，则最小值右侧的值都比x小，最小值左侧的值都比x大
 */
public class Code153 {
    public int findMin(int[] nums) {
        int low = 0;
        //nums[hight]即为x
        int hight = nums.length - 1;
        while (low < hight) {
            int mid = (low + hight) / 2;
            //元素比x大，证明最小值在右侧，舍弃左半部分
            if (nums[mid] > nums[hight]) {
                low = mid + 1;
            }
            //舍弃右半部分
            else {
                hight = mid;
            }
        }
        return nums[low];
    }
}
