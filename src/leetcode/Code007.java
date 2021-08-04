package leetcode;

/**
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class Code007 {
    public static void main(String[] args) {
        Solution07 s7 = new Solution07();
        System.out.println(s7.reverse(321));
    }
}
class Solution07{
    public int reverse(int x) {
        int ret=0;
        if(x==0)
            return 0;

        while(x!=0){
            //pop用于记录x的末位
            int pop=x%10;
            x=x/10;
            //在java中int类型的最大值和最小值分别为2147483647和-2147483648，所以末位大于7或者小于-8有可能溢出
            if(ret>Integer.MAX_VALUE/10 || (ret==Integer.MAX_VALUE/10 && pop>7))
                return 0;
            if(ret<Integer.MIN_VALUE/10 || (ret==Integer.MIN_VALUE/10 && pop<-8))
                return 0;
            ret=ret*10+pop;

        }
        return ret;
    }
}
