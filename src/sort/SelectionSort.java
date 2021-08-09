package sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums=new int[]{5,4,6,1,2,9};
        sort(nums);
        for (int i:nums){
            System.out.print(i+",");
        }
    }
    public static void sort(int[] nums){
        int length = nums.length;
        for(int i=0;i<length-1;i++){
            int min=i;
            for(int j=i+1;j<length;j++){
                if(nums[j]<nums[min]){
                    min=j;
                }
            }
            int temp=nums[i];
            nums[i]=nums[min];
            nums[min]=temp;
        }
    }
}
