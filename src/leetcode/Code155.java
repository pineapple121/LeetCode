package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 */
public class Code155 {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public Code155() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        int minVal = minStack.peek();
        if (val < minVal) {
            minStack.push(val);
        } else {
            minStack.push(minVal);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


/**
 * 不使用辅助栈，栈中存当前值与最小值的差值
 */
class MinStack {
    Stack<Long> stack;
    //minValue要用long型，否则可能会溢出（当差值超过int最大值或最小值时）
    long minValue;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        //初始栈为空时
        if (stack.isEmpty()) {
            minValue = val;
            stack.push(val - minValue);
        } else {
            stack.push(val - minValue);
            //更新最小值
            if (val < minValue) {
                minValue = val;
            }
        }
    }

    public void pop() {
        long popVal = stack.pop();
        //出栈的是负值，该元素入栈时修改了最小值，现在应当还原
        if (popVal < 0) {
            minValue = minValue - popVal;
        }
    }

    public int top() {
        long topVal = stack.peek();
        //如果栈顶元素小于0的话，证明当前元素应当是最小值
        if (topVal < 0) {
            return (int) minValue;
        } else {
            return (int) (topVal + minValue);
        }
    }

    public int getMin() {
        return (int) minValue;
    }
}