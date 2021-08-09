package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums=new int[]{5,4,6,1,2,9};
        myBubbleSort(nums);
        for (int i:nums){
            System.out.print(i+",");
        }
    }
    public static void myBubbleSort(int[] nums){
        //当前一个循环是否出现了交换的情况，如果没有交换，证明数组已经有序，直接退出
        boolean isChanged=true;
        int length = nums.length;
        for(int i=length-1;i>0 && isChanged;i--){
            isChanged=false;
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    isChanged=true;
                }
            }
        }
    }
}
