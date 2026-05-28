import java.util.*;

class Solution {
    
    public boolean checkPath(int V, int[][] edges, int src, int dest){
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph=new ArrayList[V];
        
        // create graph- creates arraylist at each vertex to store its edges
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
        
        //add edges
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] visited= new boolean[V];
        
        return hasPath(graph,src,dest,visited);
    }
    public boolean hasPath( ArrayList<Integer>[] graph,int src, int dest,
    boolean[] visited) {
        // Code here
        
        
        if(src== dest){
            return true;
        }
        visited[src]=true;
        
        //get neighbours
        for(int i=0;i<graph[src].size();i++){
            
            int neighbour=graph[src].get(i);
            
            if(! visited[neighbour] && hasPath(graph ,neighbour,dest,visited)){
                return true;
            }
        }
        
        return false;
    }
}

