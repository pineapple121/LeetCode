package nowCoder;

/**
 * top K问题
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 */
public class Code002 {
    public int findKth(int[] a, int n, int K) {
        return findK(a,0,n-1,K);
    }
    public int findK(int[] a,int left,int right,int k){
        if(left<=right){
            int pivot=partition(a,left,right);
            if(pivot==k-1){
                return a[pivot];
            }
            //在数组的右侧寻找
            else if(pivot<k-1){
                return findK(a,pivot+1,right,k);
            }
            //在数组左侧
            else{
                return findK(a,left,pivot-1,k);
            }
        }
    return -1;
    }
    public int partition(int[] a,int left,int right){
        int pivot=a[left];
        while(left<right){
            while(left<right && a[right]>pivot)
                right--;
            swap(a,left,right);
            while(left<right && a[left]<pivot)
                left++;
            swap(a,left,right);
        }
        return left;
    }
    public void swap(int[]a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
