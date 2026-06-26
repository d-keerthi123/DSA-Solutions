//Approach :Recursive
//Time Complexity: Exponential -- due to repeated recursive calls
class Solution {
    public static int findCatalan(int n) {
        // code here
        
        //base case
        if(n==0 || n==1){
            return 1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=findCatalan(i)*findCatalan(n-i-1);
        }
        
        return ans;
    }
}
=================================================================================================================================================================
//Approach:Memoization
//Tc:O(n^2)

class Solution {
    public static int findCatalan(int n){
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        
        return findCatalanHelper(n,dp);
    }
    public static int findCatalanHelper(int n,int[] dp) {
        //base case
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=findCatalanHelper(i,dp)*findCatalanHelper(n-i-1,dp);
        }
        
        return dp[n]=ans;
    }
}

======================================================================================================================================================
//Approach :Tabulation
//TC:O(n^2)
class Solution {
    public static int findCatalan(int n) {
        
        int dp[]=new int[n+1];
        
        //base case initialization
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2;i<=n;i++){ //n value 
            for(int j=0;j<=i-1;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        
        return dp[n];
    }
}

