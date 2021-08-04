package SwordOffer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
 *
 * 可以证明这种方法不会错过目标值。如果当前元素大于目标值，说明当前元素的下边的所有元素都一定大于目标值，因此往下查找不可能找到目标值，往左查找可能找到目标值。
 * 如果当前元素小于目标值，说明当前元素的左边的所有元素都一定小于目标值，因此往左查找不可能找到目标值，往下查找可能找到目标值。
 *
 * 若数组为空，返回 false
 * 初始化行下标为 0，列下标为二维数组的列数减 1
 * 重复下列步骤，直到行下标或列下标超出边界
 * 获得当前下标位置的元素 num
 * 如果 num 和 target 相等，返回 true
 * 如果 num 大于 target，列下标减 1
 * 如果 num 小于 target，行下标加 1
 */
public class Offer004 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        int rows=matrix.length;
        int columns=matrix[0].length;
        //从矩阵的右上角开始查找
        int row=0;
        int col=columns-1;
        while(row<rows&&col>=0){
            if(matrix[row][col]==target)
                return true;
            //target比当前值小，证明该列向下的值都不可能为target，应向左寻找
            else if(target<matrix[row][col])
                col--;
            //target比当前值大，证明该行左边的值都不可能为target，应向下寻找
            else
                row++;
        }
        return false;
    }
}
