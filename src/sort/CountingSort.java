package sort;

/**
 * 计数排序
 * https://www.runoob.com/w3cnote/counting-sort.html
 */

public class CountingSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 6, 1, 2, 9};
        countingSort(nums);
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }
    public static void countingSort(int[] arr){
        int bucketLen=getMaxValue(arr)+1;
        int[] bucket=new int[bucketLen];
        for (int val:arr) {
            bucket[val]++;
        }
        int sortedIndex=0;
        for(int j=0;j<bucketLen;j++){
            while(bucket[j]>0){
                arr[sortedIndex++]=j;
                bucket[j]--;
            }
        }
    }
    public static int getMaxValue(int[] arr){
        int len=arr.length;
        int max=arr[0];
        for (int value:arr) {
            if(value>max){
                max=value;
            }
        }
        return max;
    }
}
