package leetcode;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 思路：
 * 用一个k个元素的小顶堆，比堆顶元素大的加入堆中，并调整堆。比堆顶元素小的直接抛弃
 * 最后堆顶元素即为所求
 */
//public class Code215 {
//    public int findKthLargest(int[] nums, int k) {
//        Queue<Integer> smallHeap=new PriorityQueue<>();
//        for(int i=0;i<nums.length;i++){
//            if(smallHeap.size()<k){
//                smallHeap.add(nums[i]);
//            }else{
//                if(nums[i]>smallHeap.peek()){
//                    smallHeap.remove();
//                    smallHeap.add(nums[i]);
//                }
//            }
//        }
//        return smallHeap.peek();
//    }
//}

//利用选择快排，当排序的下标恰好为倒数第k个下标时即可返回
//public class Code215 {
//    public int findKthLargest(int[] nums, int k) {
//        return quickSelectSort(nums,0,nums.length-1,nums.length-k);
//
//    }
//    public int quickSelectSort(int[] nums,int left,int right,int k){
//        int p=partion(nums,left,right);
//        if(p==k)
//            return nums[k];
//        else if(p<k){
//            return quickSelectSort(nums,p+1,right,k);
//        }else{
//            return quickSelectSort(nums,left,p-1,k);
//        }
//    }
//    public int partion(int[] nums,int left,int right){
//        int p=nums[left];
//        while(left<right){
//            while(left<right && nums[right]>=p)
//                right--;
//            swap(nums,left,right);
//            while(left<right && nums[left]<=p)
//                left++;
//            swap(nums,left,right);
//        }
//        return left;
//    }
//    public void swap(int[]a,int i,int j){
//        int temp=a[i];
//        a[i]=a[j];
//        a[j]=temp;
//    }
//}


//手动创建大根堆，进行k次选择，即得所求
//public class Code215 {
//    public int findKthLargest(int[] nums, int k) {
//        int heapSize = nums.length;
//        //建立大根堆
//        buildMaxHeap(nums, heapSize);
//        //选择并调整k-1次,堆顶元素即为第k大元素
//        for (int i = 0; i < k - 1; i++) {
//            //交换末尾元素
//            swap(nums, 0, heapSize - 1);
//            heapSize--;
//            heapModify(nums, 0, heapSize);
//        }
//        return nums[0];
//    }
//
//    public void buildMaxHeap(int[] nums, int heapSize) {
//        for (int i = heapSize / 2; i >= 0; i--) {
//            heapModify(nums, i, heapSize);
//        }
//    }
//
//    //递归调整大根堆，其实是一种下沉操作
//    public void heapModify(int[] nums, int i, int heapSize) {
//        //左孩子
//        int left = i * 2 + 1;
//        //右孩子
//        int right = i * 2 + 2;
//        //记录当前节点，两个孩子节点，三个节点中较大的那一个
//        int largest = i;
//        //两个if相当于选择较大的孩子节点进行交换
//        if (left < heapSize && nums[left] > nums[largest]) {
//            largest = left;
//        }
//        if (right < heapSize && nums[right] > nums[largest]) {
//            largest = right;
//        }
//        //当前节点比两个孩子节点都大就不用交换
//        if (largest != i) {
//            swap(nums, largest, i);
//            //继续向下调整堆
//            heapModify(nums, largest, heapSize);
//        }
//    }
//
//    public void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//}


//创建k个元素的小根堆
public class Code215 {
    public int findKthLargest(int[] nums, int k) {
        buildMinHeap(nums, k);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                swap(nums, 0, i);
                modifyHeap(nums, 0, k);
            }
        }
        return nums[0];
    }

    //构造小根堆
    public void buildMinHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            modifyHeap(nums, i, heapSize);
        }
    }

    public void modifyHeap(int[] nums, int i, int heapSize) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int minP = i;
        if (left < heapSize && nums[left] < nums[minP]) {
            minP = left;
        }
        if (right < heapSize && nums[right] < nums[minP]) {
            minP = right;
        }
        if (minP != i) {
            swap(nums, i, minP);
            modifyHeap(nums, minP, heapSize);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}