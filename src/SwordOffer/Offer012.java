package SwordOffer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 用深度搜索，用一个二维数组来标记board中的每一位是否访问过
 */
public class Offer012 {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 ||board[0].length==0)
            return false;
        if(word==null || word.length()==0)
            return false;
        boolean[][] flag=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,i,j,word,0,flag))
                    return true;
            }
        }
        return false;

    }
    public boolean dfs(char[][] board,int row,int col,String word ,int index,boolean[][] flag){
        if(index==word.length())
            return true;
        if(row>=board.length || row<0 || col>=board[0].length || col<0)
            return false;
        //访问过该路径，直接返回
        if(flag[row][col]==true)
            return false;

        flag[row][col]=true;
        //定义四个搜索方向
        int[][] head=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        //进行深度搜索
        if(word.charAt(index)==board[row][col]){
            for(int i=0;i<4;i++){
                if(dfs(board,row+head[i][0],col+head[i][1],word,index+1,flag))
                    return true;

            }
        }

        flag[row][col]=false;
        return false;

    }
}
