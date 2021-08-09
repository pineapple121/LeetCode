package sort;


/**
 * 递归的算法主要是在划分子区间，如果要非递归实现快排，只要使用一个栈来保存区间就可以了。
 * 一般将递归程序改成非递归首先想到的就是使用栈，因为递归本身就是一个压栈的过程。
 */

import java.util.Stack;

public class QuickSortNoRecursion {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 6, 1, 2, 9};
        quickSortNoR(nums);
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }

    public static void quickSortNoR(int[] array){
        Stack<Integer> s= new Stack<>();
        s.push(0);
        s.push(array.length-1);
        while(!s.isEmpty()){
            int right=s.pop();
            int left=s.pop();
            int index=PartSort(array,left,right);
            if((index-1)>left){
                s.push(left);
                s.push(index-1);
            }
            if((index+1)<right){
                s.push(index+1);
                s.push(right);
            }
        }
    }
    public static int PartSort(int[]array,int left,int right){
        int mid=left;
        while(left<right){
            while(left<right && array[right]>=array[mid]){
                right--;
            }
//            swap(array,right,mid);
            while(left<right && array[left]<=array[mid]){
                left++;
            }
            swap(array,left,right);
        }
        swap(array,left,mid);
        return left;
    }
    public static void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
