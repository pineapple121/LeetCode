package leetcode;

/**
 * 反转字符串 II
 *
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code541 {
    public String reverseStr(String s, int k) {
        boolean reverse=true;
        char[] arr=s.toCharArray();
        int left=0;
        int right=0;
        while(left<s.length()){
            right=Math.min(left+k,s.length())-1;
            if(reverse){
                reverseChar(arr,left,right);
                reverse=false;
            }else{
                reverse =true;
            }
            left=right+1;
        }
        return new String(arr);
    }
    public void reverseChar(char[] arr,int left,int right){
        while(left<right){
            char temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
}
