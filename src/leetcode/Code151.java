package leetcode;

/**
 * 151. 翻转字符串里的单词
 */
public class Code151 {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder ans = new StringBuilder();
        int len = strArr.length;
        for (int i = len - 1; i >= 0; i--) {
            if (strArr[i].length() != 0) {
                if (ans.length() != 0) {
                    ans.append(" " + strArr[i]);

                } else {
                    ans.append(strArr[i]);
                }
            }
        }
        return ans.toString();
    }
}
