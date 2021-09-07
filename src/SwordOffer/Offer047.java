package SwordOffer;

/**
 * @program: LeetCode
 * @Description: 礼物的最大价值
 * @Author: Marco
 * @Date: 2021-09-07 16:14
 **/

public class Offer047 {
    public int maxValue(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }
}
