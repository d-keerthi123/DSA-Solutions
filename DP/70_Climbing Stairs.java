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
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
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
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n]=climbStairsM(n-1,dp) +climbStairsM(n-2,dp);
        return dp[n];
    }
}
