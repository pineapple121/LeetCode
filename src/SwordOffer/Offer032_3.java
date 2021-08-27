package SwordOffer;

import java.util.*;

/**
 * @program: LeetCode
 * @Description: 之字形层序遍历二叉树
 * @Author: Marco
 * @Date: 2021-08-26 11:17
 **/

public class Offer032_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                list.add(p.val);
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            if (reverse) {
                Collections.reverse(list);
            }
            ans.add(list);
            reverse = !reverse;
        }
        return ans;
    }
}
