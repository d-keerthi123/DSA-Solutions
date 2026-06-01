class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        //build a graph
         @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph= new ArrayList[V];
        
        for(int i=0;i<V;i++){
            graph[i]= new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            graph[u].add(v);
            graph[v].add(u);
            
        }
        // -1 = uncoloured
        int[] colour= new int[V];
        
        for(int i=0;i<V;i++){
            colour[i] =-1; //initially no colour
        }
        
        //BFS
        Queue<Integer> q= new LinkedList<>();
        
        // handle disconnected graph
        for(int i=0;i<graph.length;i++){
            if(colour[i]==-1){
                q.add(i);
                colour[i]=0; 
                
                while(!q.isEmpty()){
                    
                    int curr=q.remove();
                    
                    //get neighbours of curr
                    for(int j=0;j<graph[curr].size();j++){
                        int neighbour=graph[curr].get(j);
                        
                        if(colour[neighbour] == -1){
                            int nextColour = colour[curr]== 0?1 :0;
                            colour[neighbour] = nextColour;
                            q.add(neighbour);
                            
                        }else if(colour[neighbour] == colour[curr]){
                            return false; // non bipartite
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
