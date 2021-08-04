package SwordOffer;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Offer029 {
    public static void main(String[] args) {
        int[][]matrix =new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix==null|| matrix.length==0 || matrix[0].length==0){
            return new int[0];
        }
        int left=0,right=matrix[0].length-1,top=0,bottom=matrix.length-1;
        int []ans=new int[matrix[0].length *matrix.length];
        int index=0;
        while(left<=right && top<=bottom){
            for(int column=left;column<=right;column++){
//                int row=top;
                ans[index++]=matrix[top][column];
            }
            for(int row=top+1;row<=bottom;row++){
                ans[index++]=matrix[row][right];
            }
            if(left<right && top<bottom){
                for(int column=right-1;column>=left;column--){
                    ans[index++]=matrix[bottom][column];
                }
                for(int row=bottom-1;row>top;row--){
                    ans[index++]=matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
