package nowCoder;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.给定有序无重复数组arr，和目标数target，找出arr里所有和为target的数值对
 */
public class Code001 {
    public static void main(String[] args) {
        int nums[]=new int[]{1,3,5,7,9};
        findTarget(nums,8);
        for(List<Integer> list:ans){
            for(Integer a:list){
                System.out.print(a+",");
            }
            System.out.println();
        }
    }
    static List<List<Integer>> ans;
    public static void findTarget(int[] nums,int target){
        ans=new ArrayList<>();
//        List<Integer> list=new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTrace(nums, visited,0, 0,target);

    }
    public static void backTrace(int[] nums,boolean[] visited,int n,int sum,int target){
        if(n==nums.length){
            return ;
        }
        if(sum==target){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0;i<=n;i++){
                if(visited[i]){
                    list.add(nums[i]);
                }
            }
            ans.add(list);
            return;
        }
        for(int i=n;i<nums.length;i++){
            if(!visited[i]){
                sum=sum+nums[i];
                visited[i]=true;
            }
            backTrace(nums,visited,i+1,sum,target);
            visited[i]=false;
            sum-=nums[i];
        }


    }
}
