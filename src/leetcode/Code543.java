package leetcode;

/**
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点
 */
public class Code543 {
    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 1;
        findMaxHeight(root);
        //直径为节点数减一
        return diameter - 1;
    }

    public int findMaxHeight(TreeNode node) {
        if (node == null)
            return 0;
        int leftHeight = findMaxHeight(node.left);
        int rightHeight = findMaxHeight(node.right);
        diameter = Math.max(diameter, leftHeight + rightHeight + 1);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
