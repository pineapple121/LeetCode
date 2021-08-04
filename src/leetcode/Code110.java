package leetcode;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class Code110 {
    //自底向上的遍历，类似于后续遍历，不同的是每个节点p只会调用一次height(p)，时间复杂度为O(n),比下一种方法更快
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode tree) {
        if (tree == null)
            return 0;
        int leftHeight = height(tree.left);
        int rightHeight = height(tree.right);
        if (leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            return -1;
        }
    }

    //自顶向下的递归，会存在一些节点p存在多次调用height(p)的情况，时间复杂度为O(n)
//    public boolean isBalanced(TreeNode root) {
//        if (root == null)
//            return true;
//        int leftHeight = height(root.left);
//        int rightHeight = height(root.right);
//        if (isBalanced(root.left) && isBalanced(root.right) && Math.abs(leftHeight - rightHeight) <= 1)
//            return true;
//        return false;
//    }
//
//    public int height(TreeNode tree) {
//        if (tree == null)
//            return 0;
//        int leftHeight = height(tree.left);
//        int rightHeight = height(tree.right);
//        return Math.max(leftHeight, rightHeight) + 1;
//    }
}
