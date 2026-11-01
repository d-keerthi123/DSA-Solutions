//TC:O(n*n)
//SC:O(1) auxiliary space

class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][]=new int[n][n];

        int num=1;
        int top=0;
        int down=n-1;
        int left=0;
        int right=n-1;
        
        int dir=0;

        //dir ==0 left to right
        //dir ==1 top to down
        //dir ==2 right to left
        //dir ==3 down to top


        while(top<=down && left<=right){
            if(dir==0){
                //row constant(top) col changes
                //move left to right
                for(int i=left; i<=right;i++){
                    matrix[top][i]=num++;
                }
                top++;
            }
            if(dir==1){
                //row changes  col constant(right)
                //move top to down
                for(int i=top; i<=down;i++){
                    matrix[i][right]=num++;
                }
                right--;
            }
            if(dir==2){
                //row constant(down)  col changes
                //move right to left
                for(int i=right; i>=left;i--){
                    matrix[down][i]=num++;
                }
                down--;
            }
            if(dir==3){
                //row changes  col constant(left)
                //move down to top
                for(int i=down; i>=top;i--){
                   matrix[i][left]=num++;
                }
                left++;
            }
            dir++;
            if(dir==4){
                dir=0; //start direction again from 0
            }
        }
        return matrix;
    }
}
