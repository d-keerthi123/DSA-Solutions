//Approach 1: Recursive
//Tc:O(2^(n+m))

class Solution {
    public int longestCommonSubsequence(String text1, String text2){
        int n=text1.length();
        int m=text2.length();
        return longestCommonSubsequenceH(text1,text2,n,m);
    }
    public int longestCommonSubsequenceH(String text1, String text2,int n,int m) {
        //base case
        if(n==0 || m==0){
            return 0;
        }

        //case 1: if the last character is the same
        if(text1.charAt(n-1) == text2.charAt(m-1)){
            return longestCommonSubsequenceH(text1,text2,n-1,m-1)+1;
        }
        else{
            //case 2:last character is different 
            int ans1=longestCommonSubsequenceH(text1,text2,n-1,m);
            int ans2=longestCommonSubsequenceH(text1,text2,n,m-1);
            return Math.max(ans1,ans2);
        }

    }
}

==============================================================================================================================================================
//Approach 2: Memoization
//TC:O(nxm)
    
class Solution {
    public int longestCommonSubsequence(String text1, String text2){
        int n=text1.length();
        int m=text2.length();

        //initialization
        int dp[][]= new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        return longestCommonSubsequenceH(text1,text2,n,m,dp);
    }
    public int longestCommonSubsequenceH(String text1, String text2,int n,int m,int[][] dp) {
        //base case
        if(n ==0 || m==0){
            return 0;
        }
        //check
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        //case 1: if the last character is the same
        if(text1.charAt(n-1) == text2.charAt(m-1)){
            //before returning store the value 
            return dp[n][m]=longestCommonSubsequenceH(text1,text2,n-1,m-1,dp)+1;
        }
        int ans1=longestCommonSubsequenceH(text1,text2,n-1,m,dp);
        int ans2=longestCommonSubsequenceH(text1,text2,n,m-1,dp);
        return dp[n][m]=Math.max(ans1,ans2);
    }
}
