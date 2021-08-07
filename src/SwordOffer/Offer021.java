package SwordOffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Offer021 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            //找到第一个偶数
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            //从后往前，找到第一个奇数
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            swap(nums, left, right);
            left++;
            right--;
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
