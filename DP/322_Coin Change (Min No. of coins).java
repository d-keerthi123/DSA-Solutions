//Approach :Tabulation
//TC:O(nxsum)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int INF=Integer.MAX_VALUE-1;
        int dp[][]=new int[n+1][amount+1];
        
        //base case initialization
        for(int i=0;i<=n;i++){ //col
            dp[i][0]=0;
        }
        for(int j=1;j<=amount;j++){ //row
            dp[0][j]=INF;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                //valid 
                if(coins[i-1]<=j){
                    //When you include a coin, you've used one coin, so:
                    int include=1+dp[i][j-coins[i-1]];
                    int exclude=dp[i-1][j];
                    dp[i][j]=Math.min(include,exclude);
                }
                else{
                    //in valid---> exclude 
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[n][amount]==INF?-1:dp[n][amount];
    }
}
