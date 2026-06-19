//Approach :Tabulation
//TC:O( n x rodLength)
class Solution {
    public int cutRod(int[] price) {
        // code here
        int[] length=new int[price.length];
        for(int i=0;i<length.length;i++){
            length[i]=i+1;
        }
        
        int n=length.length;
        int rodLength=n;
        
        int dp[][]=new int[n+1][rodLength+1];
        
        for(int i=0;i<dp.length;i++){ // col 0
            dp[i][0]=0;
        }
        
        for(int j=0;j<dp[0].length;j++){ //row 0
            dp[0][j]=0;
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<rodLength+1;j++){
                if(length[i-1] <=j){
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]] , dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[n][rodLength];
    }
}
