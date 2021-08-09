package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class Code054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = columns - 1;
        while (top <= bottom && left <= right) {
            //从左往右
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            //从上往下
            for (int i = top + 1; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            //如果已经遍历完数组则不需要再从右往左和从下往上
            if (left < right && top < bottom) {
                //从右向左
                for (int j = right - 1; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }
                //从下向上
                for (int i = bottom - 1; i > top; i--) {
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
