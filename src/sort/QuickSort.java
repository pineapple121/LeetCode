package sort;

public class QuickSort {
    public static void main(String[] args) {
//        int[] nums = new int[]{5, 4, 6, 1, 2, 9};
        int[] nums=new int[]{5,1,1,2,0,0};
        myQuickSort(nums, 0, nums.length-1);
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }
    public static void myQuickSort(int[] nums,int start,int end){
        int flag=nums[start];
        int i=start;
        int j=end;
        while(i<j){
            while(i<j && nums[j]>=flag)
                j--;
            swap(nums,i,j);
            while(i<j && nums[i]<=flag)
                i++;
            swap(nums,i,j);
        }
        if(i-1>start)
            myQuickSort(nums,start,i-1);
        if(j+1<end)
            myQuickSort(nums,j+1,end);
    }
    public static void swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
