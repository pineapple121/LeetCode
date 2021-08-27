package demo.multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @Description: 三个线程交替打印123
 * @Author: Marco
 * @Date: 2021-08-26 20:26
 **/

public class ThreeThreadPrint123 {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        Condition C = lock.newCondition();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (count < 20) {
                        if (count % 3 != 0) {
                            A.await();
                        }
                        System.out.println(Thread.currentThread().getName() + " " + count);
                        count++;
                        B.signal();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "线程1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (count < 20) {
                        if (count % 3 != 1) {
                            B.await();
                        }
                        System.out.println(Thread.currentThread().getName() + " " + count);
                        count++;
                        C.signal();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "线程2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    while (count < 20) {
                        if (count % 3 != 2) {
                            C.await();
                        }
                        System.out.println(Thread.currentThread().getName() + " " + count);
                        count++;
                        A.signal();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "线程3");
        t1.start();
        Thread.sleep(10);
        t2.start();
        t3.start();
    }
}
