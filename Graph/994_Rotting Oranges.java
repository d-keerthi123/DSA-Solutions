class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length; //row
        int n=grid[0].length; //col

        Queue<int[]> q= new LinkedList<>();
        int freshOranges=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){  //rotten oranges 
                    q.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                     freshOranges++; //increase count of fresh oranges
                }
            }
        }
        if(freshOranges==0){ //if no fresh oranges
            return 0;
        }
        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}}; //up down left right
        int mins=0;
        while(! q.isEmpty()){
            int k=q.size();
            while( k-- > 0){
                int[] curr=q.remove();
                int row=curr[0];
                int col=curr[1];

                for(int i = 0; i < directions.length; i++) {
                    int[] dir = directions[i];

                    int newR=row+dir[0];
                    int newC=col+dir[1];

                    if(newR >=0 && newR<m && newC >=0 && newC<n && grid[newR][newC] ==1){
                        grid[newR][newC]=2;
                        freshOranges--;
                        q.add(new int[]{newR,newC});
                    }
                }
            }
            mins++;
        }

        if(freshOranges==0){
            return mins-1;
        }
        return -1;
    }
}
