//Approach:Tabulation
//TC:O(nxm)

class Solution {
    public int minOperations(String s1, String s2) {
        // Your code goes here
        
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        
        //base case initialization
        for(int i=0;i<=n;i++){
            dp[i][0]=0; 
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=0; 
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1] +1;
                }
                else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j]=Math.max(ans1,ans2);
                }
            }
        }
        int delete=n-dp[n][m]; //no of delete operations
        int add=m-dp[n][m];//no of add operations
        
        return delete+add;
    }
}
