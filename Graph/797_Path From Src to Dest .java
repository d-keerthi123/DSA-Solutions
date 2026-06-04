class Solution {
    public List<List<Integer>> dfs (int[][] graph,int src, int dest,List<Integer> path, List<List<Integer>> ans){
        path.add(src);

        // Reached destination
        if(src== dest){
            ans.add(new ArrayList<>(path));
        }

        for(int i=0;i<graph[src].length;i++){
            int neighbour=graph[src][i];
            dfs(graph,neighbour,dest,path,ans);
        }
        path.remove(path.size() - 1); // backtrack
        return ans;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        int dest = graph.length - 1; //last node

        return dfs(graph,0,dest,path,ans);
    }
}
