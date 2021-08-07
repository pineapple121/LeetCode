package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 */
public class Code227 {
    public int calculate(String s) {
        //定义一个栈
        Deque<Integer> stack = new LinkedList<>();
        //数字前的操作符，初始默认为‘+’
        char preSign = '+';
        //保存读到的一个数的大小
        int num = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            //是数字
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            //不是数字,前一个数的所有位已经读完了，开始运算.到达末尾，也运算
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                //并将当前符号保存
                preSign = s.charAt(i);
                //数字记录恢复为0
                num = 0;
            }
        }
        //将栈里所有数字相加即为表达式的值
        int ans = 0;
        while (!stack.isEmpty()) {
            ans = ans + stack.pop();
        }
        return ans;
    }
}
