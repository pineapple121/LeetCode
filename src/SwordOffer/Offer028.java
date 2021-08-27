package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 对称的二叉树
 * @Author: Marco
 * @Date: 2021-08-26 10:06
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 **/

public class Offer028 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isEqual(root.left, root.right);
    }

    public boolean isEqual(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isEqual(t1.left, t2.right) && isEqual(t1.right, t2.left);
    }
}
