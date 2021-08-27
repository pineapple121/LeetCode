package demo.DesignPatterns;

/**
 * @program: LeetCode
 * @Description: 双重校验实现单例模式
 * @Author: Marco
 * @Date: 2021-08-26 22:05
 **/

public class Singleton {
    //volatile防止指令重排，防止未实例化 的对象引用被其他线程获取
    private volatile static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
