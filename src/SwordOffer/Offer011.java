package SwordOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 我们考虑数组中的最后一个元素 xx：在最小值右侧的元素，它们的值一定都小于等于 xx；而在最小值左侧的元素，它们的值一定都大于等于 xx。因此，我们可以根据这一条性质，通过二分查找的方法找出最小值。
 *
 */
public class Offer011 {
    public int minArray(int[] numbers) {
        int low=0;
        int high=numbers.length-1;
        int mid=0;
        while(low<high){
            mid=(low+high)/2;
            //中间元素大于右端点，证明最小值在右半部分，舍弃左半部分
            if(numbers[mid]>numbers[high]){
                low=mid+1;
            }
            //中间元素小于右端点，证明最小值在左半部分，舍弃右半部分
            else if(numbers[mid]<numbers[high]){
                high=mid;
            }
            //中间元素与右端点相等，无法判断是在左半部分还是右半部分，直接令high-1，继续二分查找
            else{
                high--;
            }
        }
        return numbers[low];
    }
}
