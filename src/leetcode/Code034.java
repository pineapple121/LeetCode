package leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 */
public class Code034 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int index = binarySearchArray(nums, 0, nums.length - 1, target);
        if (index == -1) {
            ans[0] = index;
            ans[1] = index;
            return ans;
        }
        int start = index, end = index;
        while (start >= 0 && nums[start] == target) {
            start--;
        }
        ans[0] = start + 1;
        while (end >= 0 && end < nums.length && nums[end] == target) {
            end++;
        }
        ans[1] = end - 1;
        return ans;
    }

    public int binarySearchArray(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] > target) {
            return binarySearchArray(nums, left, mid - 1, target);
        } else {
            return binarySearchArray(nums, mid + 1, right, target);
        }
    }
}
