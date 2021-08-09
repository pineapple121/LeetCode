package leetcode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class Code236 {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return ans;
        }
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode tree, TreeNode p, TreeNode q) {
        if (tree == null) {
            return false;
        }
        //当前节点是p或q
        boolean currentFlag = tree.val == p.val || tree.val == q.val;
        //左子树是否是p和q的祖先
        boolean lflag = dfs(tree.left, p, q);
        //右子树是否是p和q的祖先
        boolean rflag = dfs(tree.right, p, q);
        if (lflag && rflag || (currentFlag && (lflag || rflag))) {
            this.ans = tree;
        }
        return lflag || rflag || currentFlag;
    }
}
