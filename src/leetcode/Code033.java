package leetcode;

/**
 * 33. 搜索旋转排序数组
 * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
 * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
 */
public class Code033 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return mid;
        if (left > right)
            return -1;
        //左半边有序
        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) {
                return binarySearch(nums, left, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, right, target);
            }
        }
        //右半边有序
        else {
            if (target > nums[mid] && target <= nums[right]) {
                return binarySearch(nums, mid + 1, right, target);
            } else {
                return binarySearch(nums, left, mid - 1, target);
            }
        }
    }
}
