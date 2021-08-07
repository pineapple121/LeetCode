package leetcode;

/**
 * @program: LeetCode
 * @Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @Author: Marco
 * @Date: 2021-08-06 10:53
 **/

/**
 * 思路：
 * 双指针，左右指针初始时都指向最左侧，右指针不断向右移动，碰见非0数和左指针进行交换
 * 左指针左边均为非0数，左指针和右指针之间均为0；
 */
public class Code283 {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }

    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
