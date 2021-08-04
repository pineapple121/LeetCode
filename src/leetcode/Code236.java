package leetcode;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 */
public class Code236 {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return this.ans;
    }
    public boolean dfs(TreeNode tree,TreeNode p,TreeNode q){
        if(tree==null)
            return false;
        boolean lflag=dfs(tree.left,p,q);
        boolean rflag=dfs(tree.right,p,q);
        if((lflag && rflag) || ((lflag || rflag) && (tree.val==p.val || tree.val==q.val)))
            this.ans=tree;
        return lflag || rflag || (tree.val==p.val) || (tree.val == q.val);
    }
}
