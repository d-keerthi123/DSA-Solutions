//Approach :Brute force
//TC:O(n*m + k(n*m))
//SC:O(k) --->extra space to store zero positions

class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> positions = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                   positions.add(new int[]{i,j});
                }
            }
        }

        //set corresponding row and columns to zero
        for(int[] position: positions){
            int x=position[0]; //row
            int y=position[1]; //column

            //set row=0
            for(int i=0;i<matrix[0].length;i++){
                matrix[x][i]=0;
            }

            //set column=0
            for(int i=0;i<matrix.length;i++){
                matrix[i][y]=0;
            }
        }

    }
}


//Better Approach
//TC:O(n*m)
//SC:O(n+m) --->extra space to store row and column where element is zero

class Solution {
    public void setZeroes(int[][] matrix) {
        int row[]=new int[matrix.length];
        int col[]=new int[matrix[0].length];
        Arrays.fill(row,-1);
        Arrays.fill(col,-1);


        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                   row[i]=0;
                   col[j]=0;
                }
            }
        }

        //set corresponding elements to zero
       for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]!=0 && (row[i]==0 || col[j]==0)){
                   matrix[i][j]=0;
                }
            }
        }

    }
}


//Optimal Approach
//TC:O(n*m)
//SC:O(1) 
class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length; //row
        int n=matrix[0].length; //col

        boolean firstRowImpacted=false;
        boolean firstColImpacted=false;


        //check whether the 1st row is impacted or not
        for(int i=0;i<n;i++){//col
            if(matrix[0][i]==0){
                firstRowImpacted=true;
                break;
            }
        }

         //check whether the 1st col is impacted or not
        for(int i=0;i<m;i++){//row
            if(matrix[i][0]==0){
                firstColImpacted=true;
                break;
            }
        }
        //set markers for the 1st row and 1st col
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                   matrix[i][0]=0;
                   matrix[0][j]=0;
                }
            }
        }

        //set corresponding element to zero
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRowImpacted){
            for(int i=0;i<n;i++){
                matrix[0][i]=0;
            }
        }
        if(firstColImpacted){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }


    }
}
