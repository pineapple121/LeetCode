package leetcode;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code169 {
    public int majorityElement(int[] nums) {
        int target = nums[0];
        //记录当前可能大于n/2数字的个数
        int targetNums = 1;
        for (int i = 1; i < nums.length; i++) {
            if (targetNums == 0) {
                target = nums[i];
                targetNums++;
            } else {
                if (target == nums[i]) {
                    targetNums++;
                } else {
                    targetNums--;
                }
            }
        }
        return target;
    }
}
