package leetcode;

/**
 * 69. x 的平方根
 * 思路：
 * 二分查找，也可使用牛顿迭代法，更快
 */
public class Code069 {
    public int mySqrt(int x) {
        int left=0,right=x;
        int ans=-1;
        int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            //转成long型很重要，否则可能出现溢出导致超时
            if((long)mid*mid<=x){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
}
