package leetcode;

import java.util.HashMap;

/**
 * 两数之和
 * 思路：
 * 遍历数组的同时，用一个hashmap来存当前元素与target的差值和下标
 * 当找到数组中当前元素在hashmap中存在，直接返回二者的下标
 */
public class Code001 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}