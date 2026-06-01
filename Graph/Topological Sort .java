//TC:O(V+E)
//SC:O(V)

class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
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
        Stack<Integer> s = new Stack<>();
        
        
         for(int i=0;i<V;i++){
            if(!visited[i]){
                topoSortUtil(graph,i,visited,s);
            }
         }
        ArrayList<Integer> result= new ArrayList<>();
            
        while(!s.isEmpty()){
            result.add(s.pop());
        }
        return result;
    }
    
    public void topoSortUtil( ArrayList<Integer>[] graph,int curr,
    boolean[] visited,Stack<Integer> s){
        visited[curr]=true;
         
         //get neighbours of curr
        for(int i=0;i<graph[curr].size();i++){
            int neighbour=graph[curr].get(i);
            
            if(!visited[neighbour]){
                topoSortUtil(graph,neighbour,visited, s);
            }
        }
         //after all neighbours
        s.push(curr);
    }
}
