package sort;

/**
 * 归并排序
 *
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums=new int[]{5,4,6,1,2,9};
        mergeSort(nums,0,nums.length-1);
        for (int i:nums){
            System.out.print(i+",");
        }
    }
    public static void mergeSort(int[] nums,int start,int end){
        if(start<end){
            int mid=(start+end)/2;
            mergeSort(nums,start,mid);
            mergeSort(nums,mid+1,end);
            merge(nums,start,mid,end);
        }
    }
    public static void merge(int[]nums,int left,int mid,int right){
        int[] temp=new int[nums.length];
        int p1=left,p2=mid+1,index=left;
        while(p1<=mid && p2<=right){
            if(nums[p1]<=nums[p2]){
                temp[index++]=nums[p1];
                p1++;
            }else{
                temp[index++]=nums[p2];
                p2++;
            }
        }
        while(p1<=mid){
            temp[index++]=nums[p1++];
        }
        while(p2<=right){
            temp[index++]=nums[p2++];
        }
        //复制回原数组
        for(int i=left;i<=right;i++){
            nums[i]=temp[i];
        }
    }
}
