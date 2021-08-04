package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 */
public class Code113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        backtrace(ans, list, root, 0, targetSum);
        return ans;
    }

    public void backtrace(List<List<Integer>> ans, List<Integer> list, TreeNode node, int sum, int target) {
        if (node == null)
            return;
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum + node.val == target) {
                ans.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
//        if (sum + node.val > target) {
//            list.remove(list.size() - 1);
//            return;
//        }
        backtrace(ans, list, node.left, sum + node.val, target);
        backtrace(ans, list, node.right, sum + node.val, target);
        list.remove(list.size() - 1);
    }
}
