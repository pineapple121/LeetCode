package sort;

/**
 * 堆排序的实现
 */
public class HeapSort {
    int N;

    public void sort(int[] arr) {
        //堆数组的第一个元素arr[0]一般不用
        //因此N即为数组中元素的个数，同时也是末尾元素的下标
        this.N = arr.length - 1;
        //从最后一个非叶子节点开始下沉构造大顶堆
        for (int k = N / 2; k >= 1; k--) {
            sink(arr, k);
        }
        //与堆顶元素交换，下沉调整堆为大根堆
        while (N > 1) {
            swap(arr, 1, N--);
            sink(arr, 1);
        }
    }

    //堆的下沉操作
    private void sink(int[] arr, int k) {
        while (2 * k <= N) {
            //该节点的左孩子
            int j = 2 * k;
            //选择较大的孩子节点来交换
            if (j < N && (arr[j] < arr[j + 1])) {
                j++;
            }
            //当前节点已经比两个孩子节点都大，不需要交换，直接退出循环
            if (arr[k] >= arr[j]) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
