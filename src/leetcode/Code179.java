package leetcode;

import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 */
public class Code179 {
    public String largestNumber(int[] nums) {
        StringBuilder ans = new StringBuilder();
        int len = nums.length;
        String[] sNums = new String[len];
        for (int i = 0; i < len; i++) {
            sNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(sNums, (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        });
        if (sNums[0].equals("0")) {
            return "0";
        }
        for (String s : sNums) {
            ans.append(s);
        }
        return ans.toString();
    }
}
