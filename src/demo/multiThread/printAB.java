package demo.multiThread;

/**
 * @program: LeetCode
 * @Description: 交替打印A1B2...
 * @Author: Marco
 * @Date: 2021-08-26 18:01
 **/

public class printAB {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        char[] arrayInt = "1234567".toCharArray();
        char[] arrayChar = "ABCDEFG".toCharArray();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrayChar.length; i++) {
                    synchronized (lock) {
                        System.out.print(arrayChar[i]);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrayInt.length; i++) {
                    synchronized (lock) {
                        System.out.println(arrayInt[i]);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        });
        t1.start();
        Thread.sleep(1);
        t2.start();
    }
}
