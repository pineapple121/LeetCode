package leetcode;

import java.util.*;

/**
 * 之字形遍历二叉树
 * 二叉树的锯齿形层序遍历
 * 思路：
 *      用一个变量记录一个层号，偶数层直接加入返回数组，奇数层翻转后再加入返回数组
 */
public class Code103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        ArrayList<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        //层序遍历需要用到队列
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level=0;
        int nextLevelCount=0;
        int currentLevelCount=1;
        int pCount=0;
        List<Integer> list=new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            pCount++;
            list.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
                nextLevelCount++;
            }
            if(node.right!=null){
                queue.add(node.right);
                nextLevelCount++;
            }
            if(pCount==currentLevelCount){

                currentLevelCount=nextLevelCount;
                nextLevelCount=0;
                pCount=0;
                level++;
                if(level%2==0){
                    Collections.reverse(list);
                }
                ArrayList<Integer> newlist=new ArrayList<>(list);
                ans.add(newlist);
                list.clear();
//                continue;
            }

        }
        return ans;
    }
}
