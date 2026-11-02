//TC:O(m+n)
//SC:O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;//row
        int n=matrix[0].length; //col

        int row=0;
        int col=n-1;

        while(row<=m && col>=0){
            if(target== matrix[row][col]){
                return true;
            }else if(target < matrix[row][col]){
                col--;
            }else{
                row++;
            }
        }

        return false;
    }
}
