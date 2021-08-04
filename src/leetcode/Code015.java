package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 思路：
 * 参考LeetCode答案
 */
public class Code015 {
    public static void main(String[] args) {
        int[] nums=new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int length=nums.length;
        Arrays.sort(nums);
        for(int first=0;first<length;first++){
            if(first>0 && nums[first]==nums[first-1])
                continue;
            int target=-nums[first];
            //使用双指针，second指向左端，third指向右端
            int third=length-1;
            for(int second=first+1;second<length;second++){
                if(second>first+1 && nums[second]==nums[second-1])
                    continue;
                while(second<third && nums[second]+nums[third]>target)
                    third--;
                //没找到，跳出当前循环
                if(second==third)
                    break;
                if(nums[second]+nums[third]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
