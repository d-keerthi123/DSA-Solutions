//Approach 1:Recursive 
//TC:O(2^n)
class Solution {
    public int knapsackH(int n,int W, int val[], int wt[]){
        //base case
        if(n==0 || W==0){
            return 0;
        }
        int take=0;
        int skip=0;
        
        if(wt[n-1]<=W){
            take=val[n-1] + knapsackH(n-1,W-wt[n-1],val,wt);
        }
        skip=knapsackH(n-1,W,val,wt);
        
        return Math.max(take,skip);
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        
        return knapsackH(n,W,val,wt);
    }
}

=========================================================================================================================================================
//Approach 2:Memoization
//TC:O(n W)
class Solution {
    public int knapsackH(int n,int W, int val[], int wt[],int dp[][]){
        //base case
        if(n==0 || W==0){
            return 0;
        }
        int take=0;
        int skip=0;
        
        if(dp[n][W] !=-1){
            return dp[n][W];
        }
        
        if(wt[n-1]<=W){
            take=val[n-1] + knapsackH(n-1,W-wt[n-1],val,wt,dp);
        }
        skip=knapsackH(n-1,W,val,wt,dp);
        
        dp[n][W]=Math.max(take,skip);
        return dp[n][W];
    }
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        
        int dp[][]=new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        
        return knapsackH(n,W,val,wt,dp);
    }
}

================================================================================================================================================
//Approach 3:Tabulation
//TC:O(n W)
class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        
        int dp[][]=new int[n+1][W+1];
        
        for(int i=0;i<dp.length;i++){ // col 0
            dp[i][0]=0;
        }
        
        for(int j=0;j<dp[0].length;j++){ //row 0
            dp[0][j]=0;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                int v=val[i-1];
                int w=wt[i-1];
                if(w <= j){
                    int inculdeProfit=v+ dp[i-1][j-w];
                    int excludeProfit=dp[i-1][j];
                    dp[i][j]=Math.max(inculdeProfit,excludeProfit);
                }else{
                    int excludeProfit=dp[i-1][j];
                    dp[i][j]=excludeProfit;
                }
            }
        }
        return dp[n][W];
    }
}


  
