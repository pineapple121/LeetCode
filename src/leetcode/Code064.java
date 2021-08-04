package leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class Code064 {

    //动态规划算法
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        //第一行的数据
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //第一列的数据
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }

    //使用回溯，超时
//    private int minPathLen = Integer.MAX_VALUE;
//
//    public int minPathSum(int[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return -1;
//        }
//        backTrace(0, 0, grid, 0);
//        return minPathLen;
//    }
//
//    private void backTrace(int row, int column, int[][] grid, int pathLen) {
//        //走到了右下角
//        if (row == grid.length - 1 && column == grid[0].length - 1) {
//            if (pathLen + grid[row][column] < minPathLen) {
//                minPathLen = pathLen + grid[row][column];
//            }
//            return;
//        }
//        if (row == grid.length || column == grid[0].length) {
//            return;
//        }
//        pathLen = pathLen + grid[row][column];
//        //向右走一步
//        backTrace(row, column + 1, grid, pathLen);
//        //向下走一步
//        backTrace(row + 1, column, grid, pathLen);
//
//    }
}
