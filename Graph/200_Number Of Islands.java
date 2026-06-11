//TC:O(m*n)
//Sc:O(m*n)

class Solution {
    public void dfs(char[][] grid,int i,int j){
        //base conditions
        //should not visit when:
        if(i<0 || j <0 || i>=grid.length || j>=grid[0].length || grid[i][j]!='1'){
            return;
        }

        grid[i][j]='$'; //mark visited
        //left
        dfs(grid,i,j-1);
        //right
         dfs(grid,i,j+1);
        //up
         dfs(grid,i-1,j);
        //down
         dfs(grid,i+1,j);
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int islands=0;

        for(int i=0;i<m;i++){ //row
            for(int j=0;j<n;j++){ //col
                if(grid[i][j] =='1'){
                    dfs(grid,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
}
