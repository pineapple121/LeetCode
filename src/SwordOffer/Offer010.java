package SwordOffer;


/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 */
public class Offer010 {
    public int fib(int n) {
//        if(n==0||n==1)
//            return n;
//        return fib(n-1)+fib(n-2);
        int MOD= (int) (1e9+7);
        if(n==0||n==1)
            return n;
        int a=0,b=1;
        int sum=0;
        for(int i=2;i<=n;i++){
            sum=(a+b)%MOD;
            int temp=b;
            b=sum;
            a=temp;
        }
        return sum;
    }
}
