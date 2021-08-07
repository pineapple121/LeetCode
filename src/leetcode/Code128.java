package leetcode;

/**
 * @program: LeetCode
 * @Description: 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * @Author: Marco
 * @Date: 2021-08-06 10:30
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * 思路：
 * 用一个hashset存入所有不同的数字，对于每一个数字x，判断x+1,x+2,...是否也在集合中
 * 而对于x+1开头的序列,其长度肯定不会超过x开头的序列，可以跳过
 */
public class Code128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //初始最长序列为0；
        int longestLength = 0;
        for (int num : set) {
            //前一个数不在集合中，证明是可能是一个新的连续序列，才进入判断
            if (!set.contains(num - 1)) {
                int currentLength = 0;
                int currentNum = num;
                while (set.contains(currentNum)) {
                    currentLength++;
                    currentNum++;
                }
                longestLength = Math.max(longestLength, currentLength);
            }
        }
        return longestLength;
    }
}
