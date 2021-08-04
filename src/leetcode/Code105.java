package leetcode;

import java.util.HashMap;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class Code105 {
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight || inorderLeft > inorderRight)
            return null;
        //根节点，为先序遍历的第一个节点
        int RootVal = preorder[preorderLeft];
        //根节点在中序遍历中的下标
        int inorderRootIndex = map.get(RootVal);
        int leftSubTreeNum = inorderRootIndex - inorderLeft;
        TreeNode root = new TreeNode(RootVal);
        root.left = build(preorder, inorder, preorderLeft + 1,
                preorderLeft + leftSubTreeNum, inorderLeft, inorderRootIndex - 1);
        root.right = build(preorder, inorder, preorderLeft + leftSubTreeNum + 1, preorderRight, inorderRootIndex + 1, inorderRight);
        return root;
    }
}
