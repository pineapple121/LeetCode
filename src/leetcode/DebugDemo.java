package leetcode;

public class DebugDemo {
    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(1);
        m.push(2);
        System.out.println(m.top());
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        System.out.println(m.top());
    }
}
