package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 二叉搜索树的后序遍历序列
 * @Author: Marco
 * @Date: 2021-08-27 10:20
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 **/

public class Offer033 {
    public boolean verifyPostorder(int[] postorder) {
        return recursive(postorder, 0, postorder.length - 1);
    }

    boolean recursive(int[] nums, int start, int end) {
        if (start >= end) {
            return true;
        }

        //找到第一个比根节点，即nums[end]大的节点mid，划分左右子树
        int mid = start;
        while (nums[mid] < nums[end]) {
            mid++;
        }
        //判断右子树中的节点值是否都大于根节点
        int p = mid;
        while (nums[p] > nums[end]) {
            p++;
        }
        return p == end && recursive(nums, start, mid - 1) && recursive(nums, mid, end - 1);
    }
}
