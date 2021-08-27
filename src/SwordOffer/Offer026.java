package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 树的子结构
 * @Author: Marco
 * @Date: 2021-08-26 09:30
 **/

public class Offer026 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        //B是否是以A为根节点的树的子结构，否则判断A的左子树和右子树，有一个满足要求即可
        return isSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean isSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null || t1.val != t2.val) {
            return false;
        }
        return isSubTree(t1.left, t2.left) && isSubTree(t1.right, t2.right);
    }
}
