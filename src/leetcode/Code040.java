package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 思路：参考力扣精选题解，回溯算法+剪枝
 * https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
 */
public class Code040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTrace(candidates,0,target,list,ans);
        return ans;
    }
    public void backTrace(int[] candidates,int n,int target,List<Integer>list,List<List<Integer>> ans){
        if(n==candidates.length)
            return;
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=n;i<candidates.length;i++){
            if(target-candidates[i]<0){
                break;
            }
            if(i>n && candidates[i]==candidates[i-1]){
                continue;
            }
            list.add(candidates[i]);
            backTrace(candidates,i+1,target-candidates[i],list,ans);
            list.remove(list.size()-1);
        }
    }
}
