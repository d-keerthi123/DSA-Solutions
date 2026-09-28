//Time Complexity O(n)
//Space Complexity O(1)

class Solution {
    public int maxProfit(int[] prices) {
        //the buying price should be min and selling price should be max
        int maxProfit=0;
        int bestBuy=prices[0]; //initally

        for(int i=0;i<prices.length;i++){
            if(prices[i]>bestBuy){
                int profit=prices[i]-bestBuy;
                maxProfit=Math.max(maxProfit,profit);
            }
            bestBuy=Math.min(bestBuy,prices[i]);
        }

        return maxProfit;
    }
}
