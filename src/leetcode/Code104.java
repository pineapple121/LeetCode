package leetcode;

/**
 * 104. 二叉树的最大深度
 * 思路：
 * 递归，最大深度=max(左子树最大深度，右子树最大深度)+1
 */
public class Code104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
