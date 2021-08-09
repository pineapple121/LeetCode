package leetcode;

/**
 * 二分查找
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Code704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    /**
     * 方法二：递归查找
     *     public int search(int[] nums, int target){
     *         return binarySearch(nums,target,0,nums.length-1);
     *
     * }
     *     public int binarySearch(int[] nums, int target, int left, int right) {
     *         if (left<0 || right>=nums.length || right<left) {
     *             return -1;
     *         }
     *         int mid = (left + right) / 2;
     *         if (nums[mid] == target) {
     *             return mid;
     *         } else if (nums[mid] > target) {
     *             return binarySearch(nums, target, left, mid - 1);
     *         } else {
     *             return binarySearch(nums, target, mid + 1, right);
     *         }
     *     }
     */
}
