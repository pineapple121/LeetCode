package leetcode;

/**
 *
 * 371.两数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * 思路：
 * a + b 的问题拆分为 (a 和 b 的无进位结果) + (a 和 b 的进位结果)
 * 无进位加法使用异或运算计算得出
 * 进位结果使用与运算和移位运算计算得出
 * 循环此过程，直到进位为 0
 *
 * 作者：jalan
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers/solution/wei-yun-suan-xiang-jie-yi-ji-zai-python-zhong-xu-y/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Code371 {
    public int getSum(int a, int b)  {
        int ans=a^b;
        int carry=(a&b)<<1;
        while(carry!=0){
            int temp1=ans;
            int temp2=carry;
            ans=temp1^temp2;
            carry=(temp1 & temp2)<<1;
        }
        return ans;
    }

}
