package leetcode;
/**
 * 17. 电话号码的字母组合,对应手机9键
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 参考力扣回溯法
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Code017 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if(digits.length()==0)
            return ans;
        HashMap<Character,String>map=new HashMap<>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }
        };
        backtrace(ans,digits,map,0,new StringBuilder());
        return ans;

    }
    static void backtrace(List<String> ans,String digits,HashMap<Character,String>map,int index,StringBuilder sb){
        if(index==digits.length()){
            ans.add(sb.toString());
        }
        else{
            char digit=digits.charAt(index);
            String letters=map.get(digit);
            for(int i=0;i<letters.length();i++){
                sb.append(letters.charAt(i));
                backtrace(ans,digits,map,index+1,sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
