package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 */
public class Code145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (pre == root.right || root.right == null) {
                ans.add(root.val);
                pre = root;
                root = null;
            } else {
                s.push(root);
                root = root.right;
            }
        }
        return ans;
    }
}
