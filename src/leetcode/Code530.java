package leetcode;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * 思路：
 *  因是二叉搜索树，采用中序遍历，得到的顺序肯定是升序的，最小的差值会在中序遍历相邻节点产生
 */
public class Code530 {
    int min=Integer.MAX_VALUE;
    int pre=-1;
    public int getMinimumDifference(TreeNode root) {
        if(root==null)
            return -1;
        inOrder(root);
        return min;
    }
    public void inOrder(TreeNode tree){
        if(tree.left!=null)
            inOrder(tree.left);
        if(pre!=-1){
            min=Math.min(min,Math.abs(tree.val-pre));
        }
        pre=tree.val;

        if(tree.right!=null){
            inOrder(tree.right);
        }
    }
}
