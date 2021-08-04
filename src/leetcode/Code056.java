package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. 合并区间
 */
public class Code056 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }
        //将数组按第一个元素从小到大排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            //用left和right来表示已经合并的集合里末位元素的区间左值和区间右值
//            int left = list.get(list.size() - 1)[0];
//            int right = list.get(list.size() - 1)[1];
            //list中没有元素，直接添加；当前遍历的区间，左值大于right的话证明没有交集，直接加入list
            if (i == 0 || intervals[i][0] > list.get(list.size() - 1)[1]) {
                list.add(intervals[i]);
            }
            //区间有重合，选择right或intervals[i][1]中的较大值作为list末尾元素的右值
            else {
                list.get(list.size() - 1)[1] = Math.max(intervals[i][1], list.get(list.size() - 1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
