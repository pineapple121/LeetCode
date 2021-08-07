package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 给定一棵二叉搜索树，请找出其中第k大的节点。
 * @Author: Marco
 * @Date: 2021-08-06 10:23
 **/

public class Offer054 {
    int k;
    int ans;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode tree) {
        if (tree == null) {
            return;
        }
        dfs(tree.right);
        k--;
        if (k == 0) {
            ans = tree.val;
        }
        dfs(tree.left);
    }
}
