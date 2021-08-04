package leetcode;

/**
 * 136. 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 思路：使用异或运算
 * 任何数与自身异或等于0；
 * 任何数与0异或等于本身
 */
public class Code136 {
    public int findSingleNumber(int[] nums) {
        int singleNumber=0;
        for(int val:nums){
            singleNumber=singleNumber^val;
        }
        return singleNumber;
    }
}
