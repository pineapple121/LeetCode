package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 递归以及非递归的实现方法
 * <p>
 * 非递归实现：
 * 使用栈，先输出节点值，依次将右孩子和左孩子入栈
 */
public class Code144 {
    ArrayList<Integer> list = new ArrayList<>();

    //非递归
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)
            return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);

        }
        return list;
    }


    //递归的实现方法
//    public List<Integer> preorderTraversal(TreeNode root) {
//        preOrder(root);
//        return list;
//    }
//    public void preOrder(TreeNode root){
//        if(root==null){
//            return;
//        }
//        list.add(root.val);
//        preOrder(root.left);
//        preOrder(root.right);
//    }
}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
