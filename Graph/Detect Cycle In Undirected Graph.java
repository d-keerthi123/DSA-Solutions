class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
         @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph= new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] visited= new boolean[V];
        return detectCycle(graph);
    }
    
    public boolean detectCycle(ArrayList<Integer>[] graph){
        boolean[] visited= new boolean[graph.length];
        
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(detectCycleUtil(graph,visited,i,-1)){
                    return true; // cycle exists in one of the parts
                }
            }
        }
        return false;
    }
    
    public boolean detectCycleUtil(ArrayList<Integer>[] graph,boolean[] visited, int curr,int parent){
        visited[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            int neighbour=graph[curr].get(i);
            
             //unvisited
            if(!visited[neighbour]){
                if(detectCycleUtil(graph,visited,neighbour,curr)){
                    return true;
                }
            }
            else if(neighbour != parent){
                return true; 
            }
           
        }
        return false;
    }
}



