//Approach:Recursive
//Tc:O(2^n)

class Solution {
    static int matrixMultiplication(int arr[]){
        int n=arr.length;
        
        return matrixMultiplicationHelper(arr,1,n-1);
    }
    static int matrixMultiplicationHelper(int arr[],int i,int j) {
        
        //base case
        if(i==j){ // only one matrix
            return 0;
        }
        int ans=Integer.MAX_VALUE;
        
        for(int k=i;k<j;k++){
            
            int cost1=matrixMultiplicationHelper(arr,i,k);//A1.....AK  arr[i-1]*arr[k]
            int cost2=matrixMultiplicationHelper(arr,k+1,j);//Ak+1.....Aj arr[k]*arr[j]
            int cost3=arr[i-1]*arr[k]*arr[j];
            
            int finalCost=cost1+cost2+cost3;
            
            ans=Math.min(ans,finalCost);
        }
        
        return ans;
    }
}

==========================================================================================================================================================
//Approach:Memoization
//TC:O(n^2)

class Solution {
    static int matrixMultiplication(int arr[]){
        int n=arr.length;
        
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1); //fill -1 row wise
        }
        
        return matrixMultiplicationHelper(arr,1,n-1,dp);
    }
    static int matrixMultiplicationHelper(int arr[],int i,int j,int dp[][]) {
        
        //base case
        if(i==j){ // only one matrix
            return 0;
        }
        if(dp[i][j] !=-1){ //already calculated
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        
        for(int k=i;k<j;k++){
            
            int cost1=matrixMultiplicationHelper(arr,i,k,dp);//A1.....AK  arr[i-1]*arr[k]
            int cost2=matrixMultiplicationHelper(arr,k+1,j,dp);//Ak+1.....Aj arr[k]*arr[j]
            int cost3=arr[i-1]*arr[k]*arr[j];
            
            int finalCost=cost1+cost2+cost3;
            
            ans=Math.min(ans,finalCost);
        }
        
        return dp[i][j]=ans;
    }
}
