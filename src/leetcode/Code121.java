package leetcode;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int minPrice=prices[0];
        int maxProfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else{
                maxProfit=Math.max(maxProfit,prices[i]-minPrice);
            }
        }
        return maxProfit;
    }
    //暴力解法
//    public int maxProfit(int[] prices) {
//        if(prices==null || prices.length==0)
//            return 0;
//        int maxProfit=0;
//        for(int i=0;i<prices.length-1;i++){
//            int maxPrice=findMax(prices,i);
//            if(maxPrice>prices[i]){
//                if(maxPrice-prices[i]>maxProfit){
//                    maxProfit=maxPrice-prices[i];
//                }
//            }
//        }
//        return maxProfit;
//    }
//    public int findMax(int[] nums,int start){
//        int max=nums[start];
//        for(int i=start+1;i<nums.length;i++){
//            max=Math.max(max,nums[i]);
//        }
//        return max;
//    }
}
