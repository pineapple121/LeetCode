package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 */
public class Code039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        backTrace(candidates,0,target,list,ans);
        return ans;

    }
    public void backTrace(int[] candidates,int n,int target,List<Integer> list,List<List<Integer>> ans){
        if(n==candidates.length)
            return;
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0)
            return;
        //两种情况，选择当前节点和不选择当前节点
        //选择当前节点
        list.add(candidates[n]);
        backTrace(candidates,n,target-candidates[n],list,ans);
        list.remove(list.size()-1);
        //不选择当前节点
        backTrace(candidates,n+1,target,list,ans);
    }
}
