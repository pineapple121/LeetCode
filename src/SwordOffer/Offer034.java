package SwordOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @Description: 二叉树中和为某一值的路径
 * @Author: Marco
 * @Date: 2021-08-27 11:05
 **/

public class Offer034 {
    List<List<Integer>> ans;
    List<Integer> list;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ans = new ArrayList<>();
        list = new ArrayList<>();
        backTrace(root, 0, target);
        return ans;
    }

    public void backTrace(TreeNode tree, int sum, int target) {
        if (tree == null) {
            return;
        }
        list.add(tree.val);
        sum = sum + tree.val;
        if (tree.left == null && tree.right == null) {
            if (sum == target) {
                ans.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }

        backTrace(tree.left, sum, target);
        backTrace(tree.right, sum, target);
        list.remove(list.size() - 1);
    }
}
