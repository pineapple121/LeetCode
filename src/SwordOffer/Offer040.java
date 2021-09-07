package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 最小的k个数
 * @Author: Marco
 * @Date: 2021-08-31 10:52
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 **/

public class Offer040 {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSelect(arr, k, 0, arr.length - 1);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public void quickSelect(int[] arr, int k, int start, int end) {
        if (start > end) {
            return;
        }
        int flag = arr[start];
        int left = start, right = end;
        while (left < right) {
            while (left < right && arr[right] >= flag) {
                right--;
            }

            swap(arr, left, right);
            while (left < right && arr[left] <= flag) {
                left++;
            }
            swap(arr, left, right);
        }
        if (left == k) {
            return;
        } else if (left < k) {
            quickSelect(arr, k, left + 1, end);
        } else {
            quickSelect(arr, k, start, left - 1);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
