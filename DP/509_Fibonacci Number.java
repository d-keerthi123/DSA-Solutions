//TC:O(2^n) exponential 
//Approach 1 : Recurisve 
class Solution {
    public int fib(int n) {
        //base case
        if(n==0 || n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}

=================================================================================================================================================================
//Approach 2:Memoization
//TC:o(n) linear
class Solution {
    public int helper(int n,int[] f){
        //base case
        if(n==0 || n==1){
            return n;
        }
        if(f[n] != 0){
            return f[n];
        }
        f[n]=helper(n-1,f)+helper(n-2,f);
        return f[n];
    }
    public int fib(int n) {
        int[] f=new int[n+1];
        return helper(n,f);
    }
}

====================================================================================================================================================================
//Approach 3:Tabulation
//TC:O(n)
class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
