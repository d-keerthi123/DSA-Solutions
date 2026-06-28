//Approach:Recursive
//Tc:

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
