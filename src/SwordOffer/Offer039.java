package SwordOffer;
//数组中出现次数超过一半的数字

/**
 * 思路：
 *  利用摩尔投票，遍历数组，当前数字与所选众数相同，票数加一，不相同，票数减一
 *  票数减到0时，选取新的数字为新的众数
 */
public class Offer039 {
    public int majorityElement(int[] nums) {
        int voteNum=nums[0];
        int vote=1;
        for(int i=1;i<nums.length;i++){
            if(vote==0){
                voteNum=nums[i];
                vote++;
                continue;
            }
            if(nums[i]==voteNum){
                vote++;
            }else{
                vote--;
            }
        }
        return voteNum;
    }
}
