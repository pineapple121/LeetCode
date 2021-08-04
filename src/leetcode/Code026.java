package leetcode;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 维护两个指针，将相等的数交换到数组的后方
 */
public class Code026 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,1};
        int length=removeDuplicates(nums);
        for(int i=0;i<length;i++){
            System.out.println(nums[i]);
        }
    }
    public static int removeDuplicates(int[] nums) {
        int length=nums.length;
        if(length==0||length==1)
            return length;
        //用于记录删除后数组的长度
        int ans=1;
        int i=0,j=1;
        while(j<length){
            while(j<length && nums[j]==nums[i]){
                j++;
            }
            if(j==length)
                break;
            if(nums[i]!=nums[j]){
                i++;
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                ans++;
                j++;
            }

        }
        return ans;
    }
}
