package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * 思路：
 * 层序遍历，找每一层的最后一个节点，输出
 */
public class Code199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();

        if(root==null)
            return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int levelCount=1;
        while(!q.isEmpty()){
            TreeNode node=q.remove();
            if(node.left!=null)
                q.add(node.left);
            if(node.right!=null)
                q.add(node.right);
            levelCount--;
            if(levelCount==0){
                levelCount=q.size();
                ans.add(node.val);
            }

        }
        return ans;
    }
}
