package SwordOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCode
 * @Description: 序列化二叉树
 * @Author: Marco
 * @Date: 2021-08-31 10:10
 **/

public class Offer037 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        mySerialize(root, ans);
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return myDeserialize(dataList);

    }

    //先序遍历序列化二叉树
    public void mySerialize(TreeNode tree, StringBuilder ans) {
        if (tree == null) {
            ans.append("null").append(",");
            return;
        }
        ans.append(tree.val).append(",");
        mySerialize(tree.left, ans);
        mySerialize(tree.right, ans);
    }

    //用链表反序列化二叉树
    public TreeNode myDeserialize(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        root.left = myDeserialize(dataList);
        root.right = myDeserialize(dataList);
        return root;
    }
}
