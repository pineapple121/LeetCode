package SwordOffer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：使用深度搜索
 *
 */
public class Offer013 {
    public static void main(String[] args) {
        System.out.println(movingCount(3,2,17));
    }
    static int route=0;
    //定义两个搜索方向，向右和向下
    static int[][] head=new int[][]{{0,1},{1,0}};
    public static int movingCount(int m, int n, int k) {
        boolean[][]flag=new boolean[m][n];
        int ans=0;
        dfs(0,0,k,m,n,flag);
        return route;
    }
    public static void dfs(int row,int col,int k,int m,int n,boolean[][]flag){
        if(row<0 || row>=m || col<0 || col>=n){
            return;
        }
        if(flag[row][col])
            return;
        if(isLessThan(row,col,k)){
            route++;
        }else
            return;
        flag[row][col]=true;
        for(int i=0;i<2;i++){
            dfs(row+head[i][0],col+head[i][1],k,m,n,flag);
        }
    }
    public static boolean isLessThan(int row,int col,int k){
        int sum=0;
        while(row>0){
            int temp=row%10;
            sum+=temp;
            row=row/10;
        }
        while(col>0){
            int temp=col%10;
            sum+=temp;
            col=col/10;
        }
        return (sum<=k);
    }
}
