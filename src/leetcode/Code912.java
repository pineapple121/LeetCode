package leetcode;

/**
 * 912. 排序数组
 * 数组快排
 */
public class Code912 {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        int flag = nums[left];
        int i = left, j = right;
        while (i < j) {
            //从右往左，找到第一个比标志小的值
            while (i < j && nums[j] >= flag)
                j--;
            swap(nums, i, j);
            //从左往右，找到第一个比标志大的值
            while (i < j && nums[i] <= flag)
                i++;
            swap(nums, i, j);
        }
        if (i - 1 > left) {
            quickSort(nums, left, i - 1);
        }
        if (j + 1 < right) {
            quickSort(nums, j + 1, right);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 堆排序
     */
    public void heapSort(int[] nums) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        while (heapSize > 0) {
            swap(nums, 0, heapSize - 1);
            heapSize--;
            sink(nums, 0, heapSize);
        }
    }

    //建立大根堆
    public void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            sink(nums, i, heapSize);
        }
    }

    //下沉操作，将小值下沉
    public void sink(int[] nums, int i, int heapSize) {
        //左孩子和右孩子下标
        int left = 2 * i + 1, right = 2 * i + 2;
        //当前节点与左右孩子节点三者之间最大值的下标
        int largest = i;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            sink(nums, largest, heapSize);
        }
    }


    /**
     * 归并排序
     */
    public void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] tempNums = new int[nums.length];
        int tempIndex = left, p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                tempNums[tempIndex++] = nums[p1++];
            } else {
                tempNums[tempIndex++] = nums[p2++];
            }
        }
        while (p1 <= mid) {
            tempNums[tempIndex++] = nums[p1++];
        }
        while (p2 <= right) {
            tempNums[tempIndex++] = nums[p2++];
        }
        //将临时数组中的数据拷贝回来
        for (int i = left; i <= right; i++) {
            nums[i] = tempNums[i];
        }
    }
}
