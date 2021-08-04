package leetcode;

/**
 * 200. 岛屿数量
 *
 */
public class Code200 {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        int IslandsNum=0;
        int rows=grid.length;
        int columns=grid[0].length;
        for(int r=0;r<rows;r++){
            for(int c=0;c<columns;c++){
                if(grid[r][c]=='1'){
                    IslandsNum++;
                    dfs(grid,r,c);
                }
            }
        }
        return IslandsNum;
    }
    public void dfs(char[][] grid,int row,int column){
        int rows=grid.length;
        int columns=grid[0].length;
        if(row<0 || column<0 || row==rows || column==columns || grid[row][column]=='0')
            return;
        grid[row][column]='0';
        dfs(grid,row+1,column);
        dfs(grid,row-1,column);
        dfs(grid,row,column+1);
        dfs(grid,row,column-1);
    }
}
