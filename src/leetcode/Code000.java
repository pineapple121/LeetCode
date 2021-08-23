package leetcode;

/**
 * 这个类用于已经不止一次刷过的算法题，写出题解粘贴到力扣中
 */

public class Code000 {
    public void quickSort(int[] nums, int start, int end) {
        int p = nums[start];
        int left = start, right = end;
        while (left < right) {
            while (right > left && nums[right] > p) {
                right--;
            }
            swap(nums, left, right);
            while (left < right && nums[left] < p) {
                left++;
            }
            swap(nums, left, right);
        }
        if (start < left - 1) {
            quickSort(nums, start, left - 1);
        }
        if (left + 1 < end) {
            quickSort(nums, left + 1, end);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void heapSort(int[] nums) {
        buildMaxHeap(nums);
        int heapSize = nums.length;
        while (heapSize > 0) {
            swap(nums, 0, heapSize - 1);
            heapSize--;
            sink(nums, 0, heapSize - 1);
        }
    }

    public void buildMaxHeap(int[] nums) {
        int length = nums.length;
        for (int i = length / 2; i >= 0; i--) {
            sink(nums, i, length);
        }
    }

    public void sink(int[] nums, int i, int heapSize) {
        int left = i * 2 + 1, right = i * 2 + 2;
        int MaxVal = i;
        if (left < nums.length && nums[left] > nums[MaxVal]) {
            MaxVal = left;
        }
        if (right < nums.length && nums[right] > nums[MaxVal]) {
            MaxVal = right;
        }
        if (MaxVal != i) {
            swap(nums, i, MaxVal);
            sink(nums, MaxVal, heapSize);
        }

    }
}
