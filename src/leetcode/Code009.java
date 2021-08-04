package leetcode;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：将x转化为字符串，然后利用两个指针，从头尾开始比较
 * 若left==right，证明是回文，否则返回false；
 */
public class Code009 {
    public static void main(String[] args) {
        Solution09 s9=new Solution09();
        System.out.println(s9.isPalindrome(121));
    }
}
class Solution09{
    public boolean isPalindrome(int x) {
        String s= String.valueOf(x);
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else
                return false;

        }
        return true;
    }
}
