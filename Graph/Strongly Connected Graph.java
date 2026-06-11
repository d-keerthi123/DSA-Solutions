//TC:O(V+E)
class Solution {
    public void dfs( ArrayList<Integer>[] graph,int curr,boolean[] visited){
        visited[curr]=true;
        
        //check neighbours of curr
        for(int i=0;i<graph[curr].size();i++){
            int neighbour=graph[curr].get(i);
            
            if(! visited[neighbour]){
                dfs(graph,neighbour,visited);
            }
        }
    }
    
    
    public void topoSort( ArrayList<Integer>[] graph,int curr,
    boolean[] visited,Stack<Integer> s){
        visited[curr]=true;
         
         //get neighbours of curr
        for(int i=0;i<graph[curr].size();i++){
            int neighbour=graph[curr].get(i);
            
            if(!visited[neighbour]){
                topoSort(graph,neighbour,visited, s);
            }
        }
         //after all neighbours
        s.push(curr);
    }
    
    
    // Function to find number of strongly connected components in the graph
    public int kosaraju(int V, int[][] edges) {
        //build graph
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph= new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            graph[u].add(v); //src--->dest
            
        }
        // step 1 -topological sort
        boolean[] visited= new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                topoSort(graph,i,visited,s);
            }
        }
        //step 2-Transpose graph
        
        ArrayList<Integer>[] transpose= new ArrayList[V];
        for(int i=0;i<V;i++){
            visited[i]=false; //reinitialize visited 
            transpose[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            transpose[v].add(u); //dest-->src
            
        }
        
        //step 3- Dfs according to graph nodes on transpose graph
        int count=0;
        while(! s.isEmpty()){
            int curr=s.pop();
            if(!visited[curr]){
                //Whenever you start a new DFS, you've found one SCC.
                //Each DFS on the transpose graph visits exactly one SCC.
                dfs(transpose,curr,visited);
                count++;
            }
        }
        return count;
    }
}
