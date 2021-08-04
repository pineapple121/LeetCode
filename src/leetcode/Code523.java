package leetcode;

import java.util.HashMap;

/**
 * 连续的子数组和
 *
 * 给定一个包含 非负数 的数组和一个目标 整数 k ，编写一个函数来判断该数组是否含有连续的子数组，
 * 其大小至少为 2，且总和为 k 的倍数，即总和为 n * k ，其中 n 也是一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 利用前缀和，一个Hashmap
 * 设位置 j < i :
 * 0 到 j 的前缀和 preSum1 = 某常数1 * k + 余数1
 * 0 到 i 的前缀和 preSum2 = 某常数2 * k + 余数2
 * 当找到 余数1 等于 余数2时， 则 j + 1 到 i 的连续和 = preSum2 - preSum1 = (某常数2 - 某常数1) * k，
 * 必为 k 的倍数， 返回true
 *
 */
public class Code523 {
//    public boolean checkSubarraySum(int[] nums, int k) {
//        int sum=0;
//        int key=0;
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i=0;i<nums.length;i++){
//            sum=sum+nums[i];
//            if(k!=0){
//                key=sum%k;
//            }
//            if( (key==0&&sum!=0) || (map.containsKey(key)&&nums[i]!=0)){
//                return true;
//            }else{
//                map.put(key,i);
//            }
//        }
//        return false;
//    }

//    public static void main(String[] args) {
//        int[] nums=new int[]{23,2,4,6,6};
//        System.out.println(checkSubarraySum(nums,7));
//    }
    public static boolean checkSubarraySum(int[] nums, int k)  {
        int sum = 0;

        // key：区间 [0..i] 里所有元素的和 % k
        // value：下标 i
        HashMap<Integer, Integer> map = new HashMap<>();
        // 理解初始化的意义
        //令前缀和刚好整除时也能返回true,如【23,2,4,6,6,】target=7
        map.put(0, -1);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }

            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }

        }
        return false;
    }
}
