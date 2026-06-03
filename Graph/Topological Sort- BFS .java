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
        //calculate indegree
        int[] indegree= new int[V];
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                int neighbour=graph[i].get(j);
                indegree[neighbour]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        //bfs
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.remove();
            ans.add(curr); 
            
            //check for neighbours
            for(int i=0;i<graph[curr].size();i++){
                int neighbour=graph[curr].get(i);
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                }
            }
        }
        return ans;
    }
}
    
    
