package SwordOffer;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Offer007 {
    HashMap<Integer,Integer> rootMap=new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //将根节点在inorder中的顺序存到hashmap里，方便查找
        for(int i=0;i<inorder.length;i++)
            rootMap.put(inorder[i],i);
        return recursionBuildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode recursionBuildTree(int[] preorder,int[] inorder,int preorderLeft,int preorderRight,int inorderLeft,int inorderRight){
        if(preorderLeft>preorderRight||inorderLeft>inorderRight)
            return null;
        int rootVal=preorder[preorderLeft];
        TreeNode root=new TreeNode(rootVal);
        int rootIndex=rootMap.get(rootVal);
        int leftTreeLength=rootIndex-inorderLeft;
        int rightTreeLength=inorderRight-rootIndex;
        root.left=recursionBuildTree(preorder,inorder,preorderLeft+1,preorderLeft+leftTreeLength,inorderLeft,inorderLeft+leftTreeLength);
        root.right=recursionBuildTree(preorder,inorder,preorderLeft+leftTreeLength+1,preorderRight,rootIndex+1,rootIndex+rightTreeLength);
        return root;
    }
}

// Definition for a binary tree node.
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
}
