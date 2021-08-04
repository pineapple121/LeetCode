package leetcode;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPath(root, 0, targetSum);
    }

    public boolean hasPath(TreeNode tree, int sum, int targetSum) {
        if (tree == null)
            return false;
        if (tree.left == null && tree.right == null) {
            if (sum + tree.val == targetSum)
                return true;
        }
        if (hasPath(tree.left, sum + tree.val, targetSum))
            return true;
        if (hasPath(tree.right, sum + tree.val, targetSum))
            return true;
        return false;
    }
}
