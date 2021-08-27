package demo.multiThread;

/**
 * @program: LeetCode
 * @Description: 多线程交替打印数字
 * @Author: Marco
 * @Date: 2021-08-26 16:22
 **/

public class Main {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("xiancheng1");
        MyThread mt2 = new MyThread("xiancheng2");
        mt1.start();
        mt2.start();
        try {
            mt1.join();
            mt2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
