//Approach :Tabulation
//TC:O(n x sum)

class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        boolean dp[][]=new boolean[n+1][sum+1];
        //items
         for(int i=0;i<dp.length;i++){ // col 0
            dp[i][0]=true;
        }
        //target sum
        //in java , its by default its false.So no need to inialize
        // for(int j=1;j<dp[0].length;j++){ //row 0
        //     dp[0][j]=false;
        // }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                int v=arr[i-1];
                
                //include
                if(v<=j && dp[i-1][j-v]==true){
                    dp[i][j]=true;
                }
                //exclude
                else if(dp[i-1][j] ==true){
                    dp[i][j]=true;
                }
            }
        }
        
        return dp[n][sum];
    }
}
