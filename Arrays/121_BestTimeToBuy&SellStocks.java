//Time Complexity O(n)
//Space Complexity O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        
        //the buy price should be min and selling price should be max
        int buyPrice=Integer.MAX_VALUE;
         
        
        for(int i=0;i<prices.length ;i++){
            if(buyPrice < prices[i]){ //we will get profit sice the buy price is min
               int profit =prices[i] - buyPrice;
               maxProfit=Math.max(profit,maxProfit);
            }else{
                buyPrice=prices[i];
            }
        }
        return maxProfit;
    }
}
