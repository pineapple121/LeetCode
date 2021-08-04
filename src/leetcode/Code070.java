package leetcode;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Code070 {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
//        return climbStairs(n-1)+climbStairs(n-2);
        int a=1,b=2;
        int ans=0;
        for(int i=3;i<=n;i++){
            ans=a+b;
            a=b;
            b=ans;
        }
        return ans;
    }

}
