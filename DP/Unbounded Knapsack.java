//Approach :Tabulation
//TC:O( n capacity)
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n=val.length;
        
        int dp[][]=new int[n+1][capacity+1];
        
        for(int i=0;i<dp.length;i++){ // col 0
            dp[i][0]=0;
        }
        
        for(int j=0;j<dp[0].length;j++){ //row 0
            dp[0][j]=0;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=0;j<capacity+1;j++){
                int v=val[i-1];
                int w=wt[i-1];
                if(w <= j){
                    
                    int inculdeProfit=v+ dp[i][j-w];
                    int excludeProfit=dp[i-1][j];
                    dp[i][j]=Math.max(inculdeProfit,excludeProfit);
                    
                }else{
                    int excludeProfit=dp[i-1][j];
                    dp[i][j]=excludeProfit;
                }
            }
        }
        return dp[n][capacity];
    }
}
