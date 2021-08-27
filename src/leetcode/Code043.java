package leetcode;

/**
 * @program: LeetCode
 * @Description: 字符串相乘
 * @Author: Marco
 * @Date: 2021-08-24 22:11
 **/

public class Code043 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String ans = "0";
        //用num2的每一位与num1相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int n1 = num2.charAt(i) - '0';
            int carry = 0;
            StringBuilder sum = new StringBuilder();
            //i为末位，不需要补0；i为倒数第二位，需要补一个0；i为倒数第三位，需要补两个0;
            for (int k = 0; k < num2.length() - 1 - i; k++) {
                sum.append("0");
            }
            for (int j = num1.length() - 1; j >= 0; j--) {
                int n2 = num1.charAt(j) - '0';
                int temp = n1 * n2 + carry;
                sum.append(temp % 10);
                carry = (temp / 10);
            }
            if (carry != 0) {
                sum.append(carry);
            }
            ans = addString(ans, sum.reverse().toString());
        }
        return ans;
    }

    public String addString(String num1, String num2) {
        //相加从两个数的末位开始
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        StringBuilder s = new StringBuilder();
        int carry = 0;
        while (index1 >= 0 || index2 >= 0) {
            char a1 = index1 >= 0 ? num1.charAt(index1) : '0';
            char a2 = index2 >= 0 ? num2.charAt(index2) : '0';
            index1--;
            index2--;
            int sum = a1 - '0' + a2 - '0' + carry;
            s.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            s.append(carry);
        }
        return s.reverse().toString();
    }
}
