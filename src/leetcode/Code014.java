package leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Code014 {
    public static void main(String[] args) {
        String[] strs = new String[]{"cir", "car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");
        char c = 0;
        int index = 0;
        int length = strs.length;
        if (strs.length == 0)
            return "";
        if (length == 1)
            return strs[0];
        if (strs[0].length() == 0)
            return "";
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }
        while (index < minLength) {
            for (int i = 1; i < length; i++) {
                c = strs[0].charAt(index);
                if (c == strs[i].charAt(index)) {
                    if (i == length - 1) {
                        sb.append(c);
                        index++;
                    }
                } else {
                    return sb.toString();
                }
            }
        }

        return sb.toString();
    }
}
