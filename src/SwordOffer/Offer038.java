package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 字符串的排列
 * @Author: Marco
 * @Date: 2021-08-24 17:56
 **/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 思路：
 * 如果 i==n，说明我们已经填完了 n 个空位，找到了一个可行的解，我们将列表放入答案数组中，递归结束。
 * <p>
 * 如果i<n，此时需要考虑第 i个空位填哪个字符。根据题目要求我们肯定不能填已经填过的字符，因此很容易想到的一个处理手段是
 * 我们定义一个标记数组visited 来标记已经填过的字符，那么在填第 i 个字符的时候我们遍历题目给定的 n个字符，如
 * 果这个字符没有被标记过，我们就尝试填入，并将其标记，继续尝试填下一个空位
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/zi-fu-chuan-de-pai-lie-by-leetcode-solut-hhvs/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Offer038 {
    Set<String> list;
    boolean[] visited;

    public String[] permutation(String s) {
        list = new HashSet<>();
        visited = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        backtrace(s.toCharArray(), 0, sb);
        String[] ans = new String[list.size()];
        Iterator<String> it = list.iterator();
        int index = 0;
        while (it.hasNext()) {
            ans[index++] = it.next();
        }
        return ans;
    }

    //i可以理解为第i个空位应当填入哪个字符
    public void backtrace(char[] arr, int i, StringBuilder s) {
        if (i == arr.length) {
            list.add(new String(s));
        }
        for (int j = 0; j < arr.length; j++) {
            if (!visited[j]) {
                visited[j] = true;
                s.append(arr[j]);
                backtrace(arr, i + 1, s);
                visited[j] = false;
                s.deleteCharAt(s.length() - 1);
            }
        }
    }
}
