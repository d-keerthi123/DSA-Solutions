//TC:O(V+E)
//every vertex visited once → O(V) and every edge checked once (technically twice in adjacency list of undirected graph) → O(E)
//Total:O(V+E)

//SC:O(V+E)
//Adjacency list:O(V + E)
//Visited array:O(V)
//Recursion stack (worst case long chain):O(V)
//Total:O(V + E)

class Solution {
    public boolean isCycle(int V, int[][] edges) {//O(E)
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



