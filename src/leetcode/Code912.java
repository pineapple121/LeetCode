package leetcode;

/**
 * 912. 排序数组
 * 数组快排
 */
public class Code912 {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    public void quickSort(int[] nums,int left,int right){
        int flag=nums[left];
        int i=left,j=right;
        while(i<j){
            while(i<j && nums[j]>=flag)
                j--;
            swap(nums,i,j);
            while(i<j && nums[left]<=flag)
                i++;
            swap(nums,i,j);
        }
        if(i-1>left){
            quickSort(nums,left,i-1);
        }
        if(j+1<right){
            quickSort(nums,j+1,right);
        }
    }
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
