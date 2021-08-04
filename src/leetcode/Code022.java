package leetcode;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 思路：
 * 利用回溯法，参考力扣方法二
 * 如果左括号数量不大于 nn，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
 */
import java.util.ArrayList;
import java.util.List;
public class Code022 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans =new ArrayList<String>();
        backtrace(ans,new StringBuilder(),0,0,n);
        return ans;
    }
    //left,right代表左括号和右括号，n代表括号对数
    public static void backtrace(List<String> list,StringBuilder sb,int left,int right,int n){
        if(sb.length()==n*2){
            list.add(sb.toString());
            return;
        }
        //如果左括号不超过对数，可以放一个左括号
        if(left<n){
            sb.append('(');
            backtrace(list,sb,left+1,right,n);
            //回溯
            sb.deleteCharAt(sb.length()-1);
        }
        //如果右括号数量小于左括号，可以放一个右括号
        if(right<left){
            sb.append(')');
            backtrace(list,sb,left,right+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
