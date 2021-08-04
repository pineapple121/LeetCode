package leetcode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 利用栈，碰见左括号入栈，遇见右括号出栈并比较是否匹配
 */
public class Code020 {
    public static void main(String[] args) {
        System.out.println(isValid("(){}}{"));
    }
    public static boolean isValid(String s) {
        //元素个数是奇数必为假
        if(s.length()%2==1)
            return false;
        Stack<Character> stack=new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else{
                if(stack.empty())
                    return false;
                else{
                    char c=stack.pop();
                    if(s.charAt(i)==')'){
                        if(c=='(')
                            continue;
                        else
                            return false;

                    }
                    if(s.charAt(i)==']'){
                        if(c=='[')
                            continue;
                        else
                            return false;
                    }
                    if(s.charAt(i)=='}'){
                        if(c=='{')
                            continue;
                        else
                            return false;
                    }

                }
            }
        }
        if(stack.empty())
            return true;
        else
            return false;
    }
}
