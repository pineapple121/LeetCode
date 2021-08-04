package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 129. 求根节点到叶节点数字之和
 * <p>
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 */
public class Code129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        sumTree(root, list);
        return sum;
    }

    public void sumTree(TreeNode tree, List<Integer> list) {
        if (tree == null)
            return;
        list.add(tree.val);
        if (tree.left == null && tree.right == null) {
            int path = 0;
            for (Integer i : list) {
                path = path * 10 + i;
            }
            sum += path;
            list.remove(list.size() - 1);
            return;
        }
        sumTree(tree.left, list);
        sumTree(tree.right, list);
        list.remove(list.size() - 1);
    }
}
