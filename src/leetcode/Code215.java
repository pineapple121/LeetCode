package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
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
public class Code215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelectSort(nums,0,nums.length-1,nums.length-k);

    }
    public int quickSelectSort(int[] nums,int left,int right,int k){
        int p=partion(nums,left,right);
        if(p==k)
            return nums[k];
        else if(p<k){
            return quickSelectSort(nums,p+1,right,k);
        }else{
            return quickSelectSort(nums,left,p-1,k);
        }
    }
    public int partion(int[] nums,int left,int right){
        int p=nums[left];
        while(left<right){
            while(left<right && nums[right]>=p)
                right--;
            swap(nums,left,right);
            while(left<right && nums[left]<=p)
                left++;
            swap(nums,left,right);
        }
        return left;
    }
    public void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}