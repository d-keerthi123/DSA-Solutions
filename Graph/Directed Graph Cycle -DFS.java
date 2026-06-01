//TC:O(V+E)

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        //build graph
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph= new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            graph[u].add(v);
            
        }
        boolean[] visited= new boolean[V];
        
        boolean[] stack= new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(isCyclicUtil(graph,i,visited,stack)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isCyclicUtil( ArrayList<Integer>[] graph,int curr,boolean[] visited,
    boolean[] stack){
        
        visited[curr]=true;
        stack[curr]=true;
        
        //get neighbours for curr
        for(int i=0;i<graph[curr].size();i++){
            int neighbour= graph[curr].get(i);
            if(stack[neighbour]==true){
                return true; //cycle exits
            }
            
            if(!visited[neighbour]){
                if(isCyclicUtil(graph,neighbour,visited,stack)){
                    return true;
                }
            }
            
        }
        stack[curr]=false;
        return false;
    }
}
