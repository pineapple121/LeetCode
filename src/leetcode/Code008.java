package leetcode;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数 myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code008 {
    public static void main(String[] args) {
        Solution08 s8 = new Solution08();
        System.out.println(s8.myAtoi("4193 with words"));
    }
}

class Solution08 {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0)
            return 0;
        int ret = 0;
        //i用于迭代字符串
        int i = 0;
        //flag用于标记正负
        int flag = 1;
        if (s.charAt(0) == '-') {
            flag = -1;
            i++;
        }
        if(s.charAt(0)=='+')
            i++;
        while (i < s.length()) {
            int p = 0;
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                p = s.charAt(i) - '0';
            }
            else if(ret!=0)
                return ret*flag;
            else
                return 0;
            i++;
            //判断是否会溢出
            //在java中int类型的最大值和最小值分别为2147483647和-2147483648，所以末位大于7或者小于-8有可能溢出
            if (flag == 1) {
                if (ret>Integer.MAX_VALUE/10 || (ret==Integer.MAX_VALUE/10 && p>7))
                    return Integer.MAX_VALUE;
            }

            if (flag == -1) {
                if(-ret<Integer.MIN_VALUE/10 ||(-ret==Integer.MIN_VALUE/10 && p>8))
                    return Integer.MIN_VALUE;
            }
            ret=ret*10+p;
        }
        return ret * flag;
    }
}
