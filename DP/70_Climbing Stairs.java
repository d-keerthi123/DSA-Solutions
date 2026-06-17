//Approach 1: Recursive
//TC:O(2 ^n)
class Solution {
    public int climbStairs(int n) {
        //base case
        if(n == 0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        return climbStairs(n-1) +climbStairs(n-2);
    }
}

//Approach 2: Memoization
//TC:O(n)
class Solution {
    public int climbStairs(int n){
        int[] dp=new int[n+1]; //0 0 0....
        Arrays.fill(dp,-1);//-1 -1 -1....
        return climbStairsM(n,dp);
    }
    public int climbStairsM(int n,int[]dp) {
        //base case
        if(n == 0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n] != -1){ //already calculated
            return dp[n];
        }
        dp[n]=climbStairsM(n-1,dp) +climbStairsM(n-2,dp);
        return dp[n];
    }
}


//Approach 3:Tabulation
//TC:O(n)
class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1] = 1;
        
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
