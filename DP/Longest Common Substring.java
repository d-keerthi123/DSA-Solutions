//Approach:Tabulation
//TC:O(nxm)

class Solution {
    public int longCommSubstr(String s1, String s2) {
        // code here
        int n=s1.length();
        int m=s2.length();

         // Base case initialization
        int dp[][]= new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=0;
        }
        int ans=0;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                //same character
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans=Math.max(ans,dp[i][j]);
                }
                else{
                    //different character
                    dp[i][j]=0;
                }
            }
        }

        return ans;
    }
}
