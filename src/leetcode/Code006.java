/***
 *
 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 P   A   H   N
 A P L S I I G
 Y   I   R
 *
 * 思路：利用一个ArrayList矩阵，奇数趟从上往下存，偶数趟从下往上存
 */


package leetcode;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
public class Code006 {
    public static void main(String[] args) {
        Solution06 s=new Solution06();
        System.out.println( s.convert("AB",1));

    }
}
class Solution06{
    public String convert(String s, int numRows) {
        if(numRows==1)
            return s;
        ArrayList<ArrayList<Character>> list = new ArrayList();
        for(int i=0;i<numRows;i++){
            list.add(new ArrayList<Character>());
        }
        //i用于记录已经存下的char
        int i=0;
        //index记录应存的list下标
        int index=0;
        //记录index是向上增长还是向下,1向下，0向上
        int flag=1;
        StringBuilder sb=new StringBuilder("");
        while(i<s.length()){
            list.get(index).add(s.charAt(i));
            i++;
            if(index==(numRows-1))
                flag=0;
            if(index==0)
                flag=1;
            if(flag==1)
                index++;
            if(flag==0)
                index--;

        }
        for(ArrayList<Character> it:list)
            for(int j=0;j<it.size();j++)
                sb.append(it.get(j));

        return sb.toString();
    }
}
