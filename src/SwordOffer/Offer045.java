package SwordOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: LeetCode
 * @Description: 把数组排成最小的数
 * @Author: Marco
 * @Date: 2021-09-01 14:05
 **/

public class Offer045 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        //对字符串数组进行排序
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder ans = new StringBuilder();
        for (String s : strs) {
            ans.append(s);
        }
        return ans.toString();
    }
}
