package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: LeetCode
 * @Description: 最小覆盖子串
 * @Author: Marco
 * @Date: 2021-08-13 10:06
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 **/

public class Code076 {
    //存放子串t中的字符以及其个数
    Map<Character, Integer> tmap = new HashMap<>();
    //存放滑动窗口中包含有t中字符的个数
    Map<Character, Integer> windowCntMap = new HashMap<>();

    public String minWindow(String s, String t) {
        //将字符串t中包含的字符全部放入tmap中
        int tLength = t.length();
        for (int i = 0; i < tLength; i++) {
            char c = t.charAt(i);
            if (tmap.containsKey(c)) {
                tmap.put(c, tmap.get(c) + 1);
            } else {
                tmap.put(c, 1);
            }
        }
        //滑动窗口的左端点和右端点
        int left = 0, right = 0;
        //滑动窗口的最小长度
        int len = Integer.MAX_VALUE;
        //记录滑动窗口最小时，左端点和右端点的位置
        int ansL = -1, ansR = -1;
        int sLen = s.length();
        while (right < sLen) {
            char c = s.charAt(right);
            //当前字符是字符串t中的字符
            if (tmap.containsKey(c)) {
                windowCntMap.put(c, windowCntMap.getOrDefault(c, 0) + 1);
            }
            //检查滑动窗口中是否已经全部包含了t中的所有字符并且数量不少于t中的数量
            while (check() && left <= right) {
                //当前滑动窗口比较小
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansL = left;
                    ansR = right;
                }
                //左端点右移，减小窗口
                if (tmap.containsKey(s.charAt(left))) {
                    windowCntMap.put(s.charAt(left), windowCntMap.get(s.charAt(left)) - 1);
                }
                left++;
            }
            right++;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }

    //检查滑动窗口中是否已经全部包含了t中的所有字符并且数量不少于t中的数量
    public boolean check() {
        Iterator iterator = tmap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Character c = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (windowCntMap.getOrDefault(c, 0) < val) {
                return false;
            }
        }
        return true;
    }
}
