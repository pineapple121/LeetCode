package demo.multiThread;

/**
 * @program: LeetCode
 * @Description: 多线程交替打印数字
 * @Author: Marco
 * @Date: 2021-08-26 16:21
 **/

public class MyThread extends Thread {
    private String name;
    private static int i = 9;

    MyThread(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        while (i >= 0) {
            synchronized (MyThread.class) {
                System.out.println(name + "   " + i);
                i--;
                if (i < 0) {
                    System.out.println(name + "值为0，结束");
                }
                MyThread.class.notify();
                try {
                    MyThread.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
