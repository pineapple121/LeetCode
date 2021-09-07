package leetcode;

/**
 * @program: LeetCode
 * @Description: 二叉搜索树与双向链表
 * @Author: Marco
 * @Date: 2021-08-31 09:53
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 **/

public class Code426 {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        //此时pre应当指向尾结点，head指向头结点
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void inOrder(Node tree) {
        if (tree == null) {
            return;
        }
        inOrder(tree.left);
        if (pre == null) {
            head = tree;
        } else {
            pre.right = tree;
        }
        tree.left = pre;
        pre = tree;
        inOrder(tree.right);

    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
}
