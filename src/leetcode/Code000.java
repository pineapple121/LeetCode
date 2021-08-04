package leetcode;
/**
 * 这个类用于已经不止一次刷过的算法题，写出题解粘贴到力扣中
 */

import java.util.ArrayList;
import java.util.List;

public class Code000 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        backTrace(0, 0, n, s, ans);
        return ans;
    }

    private void backTrace(int left, int right, int n, StringBuilder s, List<String> ans) {
        //已经添加了足够数量的括号
        if (s.length() == n * 2) {
            ans.add(new String(s));
        }
        //可以添加一个左括号
        if (left < n) {
            s.append("(");
            backTrace(left + 1, right, n, s, ans);
            s.deleteCharAt(s.length() - 1);
        }
        //可以添加一个右括号
        if (right < left) {
            s.append(")");
            backTrace(left, right + 1, n, s, ans);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
