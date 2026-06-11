class Solution {
   public void dfs(ArrayList<Integer>[] graph,int curr,boolean[] vis){
    vis[curr]=true;

    //check for neighbours
    for(int i=0;i<graph[curr].size();i++){
        int neighbour=graph[curr].get(i);

        if(! vis[neighbour]){
            dfs(graph,neighbour,vis);
        }
    }
   }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        //Now convert matrix → graph.
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j] == 1){
                    graph[i].add(j);
                }
            }
        }
        boolean[] vis=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(! vis[i]){
                dfs(graph,i,vis);
                count++;
            }
        }
        return count;
    }
}
