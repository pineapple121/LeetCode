package leetcode;

import java.util.*;

/**
 * 之字形遍历二叉树
 * 二叉树的锯齿形层序遍历
 * 思路：
 * 用一个变量记录一个层号，偶数层直接加入返回数组，奇数层翻转后再加入返回数组
 */
public class Code103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        //层序遍历需要用到队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int nextLevelCount = 0;
        int currentLevelCount = 1;
        int pCount = 0;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            pCount++;
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                nextLevelCount++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevelCount++;
            }
            if (pCount == currentLevelCount) {

                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
                pCount = 0;
                level++;
                if (level % 2 == 0) {
                    Collections.reverse(list);
                }
                ArrayList<Integer> newlist = new ArrayList<>(list);
                ans.add(newlist);
                list.clear();
//                continue;
            }

        }
        return ans;
    }

    public List<List<Integer>> zigzagLevelOrder02(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        //遍历二叉树使用单向队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //双端队列，奇数层从队尾入队，偶数层从队首入队
            Deque<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(node.val);
                } else {
                    levelList.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            isOrderLeft = !isOrderLeft;
            ans.add(new ArrayList<>(levelList));
        }
        return ans;
    }
}
