package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Code078 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    //迭代法，某个数位为1证明子集中有该元素
//    public List<List<Integer>> subsets(int[] nums) {
//        ans = new ArrayList<>();
//        list = new ArrayList<>();
//        int n = nums.length;
//        for (int mask = 0; mask < (1 << n); mask++) {
//            list.clear();
//            for (int i = 0; i < n; i++) {
//                if ((mask & (1 << i)) != 0) {
//                    list.add(nums[i]);
//                }
//            }
//            ans.add(new ArrayList<>(list));
//        }
//        return ans;
//    }

    //回溯法
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int current, int[] nums) {
        if (current == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[current]);
        dfs(current + 1, nums);
        list.remove(list.size() - 1);
        dfs(current + 1, nums);
    }

}
