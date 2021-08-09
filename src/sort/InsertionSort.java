package sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 6, 1, 2, 9};
        myInsertionSort(nums);
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }
    public static void myInsertionSort(int[] nums){
        int length=nums.length;
        for(int i=1;i<length;i++){
            for(int j=i-1;j>0 && nums[j]<nums[j-1];j--){
                int temp=nums[j];
                nums[j]=nums[j-1];
                nums[j-1]=temp;
            }

        }
    }
}
