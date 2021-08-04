package leetcode;

/**
 * 226. 翻转二叉树
 */
public class Code226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
