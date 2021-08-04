package leetcode;

/**
 * 101. 对称二叉树
 */
public class Code101 {
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root, root);
    }

    public boolean checkSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return (p.val == q.val && checkSymmetric(p.left, q.right) && checkSymmetric(p.right, q.left));
    }
}
