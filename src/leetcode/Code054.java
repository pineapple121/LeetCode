package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class Code054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans =new ArrayList<>();
        int rows=matrix.length;
        int columns=matrix[0].length;
        int top=0,bottom=rows-1,left=0,right=columns-1;
        while(top<=bottom && left<=right){
            for(int j=left;j<=right;j++){
                ans.add(matrix[top][j]);
            }
            for(int i=top+1;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            if(left<right && top<bottom){
                for(int j=right-1;j>=left;j--){
                    ans.add(matrix[bottom][j]);
                }
                for(int i=bottom-1;i>top;i--){
                    ans.add(matrix[i][left]);
                }
            }

            top++;
            bottom--;
            left++;
            right--;

        }
        return ans;
    }
}
