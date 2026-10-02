//TC:O(n^2) bcz its n*n matrix
//SC:O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length; //row
        int m=matrix[0].length; //col

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }

        return false;
    }
}
======================================================================================================================================
//TC:O(n+m)
//SC:O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int i=0;
       int j=matrix[0].length-1;

       while(i<=j){
        if(matrix[i][j] ==target){
            return true;
        }
        else if(matrix[i][j] >target){
            j--;
        }else{
            i++;
        }
       }

       return false;
    }
}
===========================================================================================================================================

//TC:O(log(m*n))
//SC:O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int start=0;
        int end=m*n-1;

        while(start<=end){
        int mid=start+(end-start)/2;

        if(matrix[mid/n][mid%n] ==target ){
            return true;
        }else if(matrix[mid/n][mid%n] >target ){
            end=mid-1; //move left
        }else{
            start=mid+1;//move right
        }
       }

       return false;
    }
}
