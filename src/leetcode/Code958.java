package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 * 思路：
 * 若一个树是完全二叉树，假设一个节点的编号为n，则其左孩子的编号为2n，右孩子的编号为2n+1
 * 判断该树的末尾的节点的编号是否与完全二叉树相同即可
 */
public class Code958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        List<TNode> nodes = new ArrayList<>();
        nodes.add(new TNode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            TNode tNode = nodes.get(i++);
            if (tNode.number != i) {
                return false;
            }
            if (tNode.node.left != null) {
                nodes.add(new TNode(tNode.node.left, 2 * tNode.number));
            }
            if (tNode.node.right != null) {
                nodes.add(new TNode(tNode.node.right, 2 * tNode.number + 1));
            }

        }
        return nodes.get(i - 1).number == nodes.size();
    }

    class TNode {
        TreeNode node;
        int number;

        TNode(TreeNode node, int number) {
            this.node = node;
            this.number = number;
        }
    }
}
