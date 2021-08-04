package leetcode;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * topK 问题
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 思路：用一个k个元素的小顶堆
 *
 */
public class Code347 {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length<k){
            return nums;
        }
        //先统计各个元素出现的次数
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        Queue<int[]> littleHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int[] ans=new int[k];
        //遍历hashmap，找到前k高频的数字
        for(Integer key:map.keySet()){
            if(littleHeap.size()<k){
                littleHeap.add(new int[]{key,map.get(key)});
            }else{
                //有点问题，这里按照小顶堆按照key的权值来排序了，而不是出现的次数
                if(map.get(key)>littleHeap.peek()[1]){
                    littleHeap.remove();
                    littleHeap.add(new int[]{key,map.get(key)});
                }
            }
        }
        int index=0;
        while(littleHeap.size()>0){
            ans[index++]=littleHeap.poll()[0];
        }
        return ans;
    }
}
