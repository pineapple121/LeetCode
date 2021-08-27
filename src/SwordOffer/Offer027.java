package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 二叉树的镜像
 * @Author: Marco
 * @Date: 2021-08-26 09:45
 **/

public class Offer027 {
    public TreeNode mirrorTree(TreeNode root) {
        mirror(root);
        return root;
    }

    public void mirror(TreeNode tree) {
        if (tree == null) {
            return;
        }
        TreeNode temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
        mirror(tree.left);
        mirror(tree.right);
    }
}
