package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 思路：
 * dfs+回溯
 */
public class Code046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        backTrace(nums,visited,0,list,ans);
        return ans;
    }
    public void backTrace(int[] nums,boolean[] visited,int n,List<Integer>list,List<List<Integer>>ans){
        if(n==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                list.add(nums[i]);
                visited[i]=true;
                backTrace(nums,visited,n+1,list,ans);
                visited[i]=false;
                list.remove(list.size()-1);
            }

        }
    }
}
