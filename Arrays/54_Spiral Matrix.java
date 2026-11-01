//TC:O(m*n)
//SC:O(1) -->auxiliary space

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();

        int m=matrix.length; //row
        int n= matrix[0].length; //column
        int top=0;
        int down=m-1;
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
                    list.add(matrix[top][i]);
                }
                top++;
            }
            if(dir==1){
                //row changes  col constant(right)
                //move top to down
                for(int i=top; i<=down;i++){
                    list.add(matrix[i][right]);
                }
                right--;
            }
            if(dir==2){
                //row constant(down)  col changes
                //move right to left
                for(int i=right; i>=left;i--){
                    list.add(matrix[down][i]);
                }
                down--;
            }
            if(dir==3){
                //row changes  col constant(left)
                //move down to top
                for(int i=down; i>=top;i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
            dir++;
            if(dir==4){
                dir=0; //start direction again from 0
            }
        }

        return list;
    }
}
