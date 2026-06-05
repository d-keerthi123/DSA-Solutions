//TC:O(V E)

class Solution {
    class Edge {
    int dest;
    int wt;

    Edge(int dest, int wt) {
        this.dest = dest;
        this.wt = wt;
    }
}
    public int[] bellmanFord(int V, int[][] edges, int src) {
       //build graph
       @SuppressWarnings("unchecked")
       ArrayList<Edge>[] graph= new ArrayList[V];
       for(int i=0;i<V;i++){
           graph[i]=new ArrayList<>();
       }
       
       for(int i=0;i<edges.length;i++){
           int u=edges[i][0];
           int v=edges[i][1];
           int w=edges[i][2];
           
           graph[u].add(new Edge(v,w)); //directed graph
       }
       
        int dist[]= new int[graph.length];
        // for(int i=0;i<dist.length;i++){
        //     if(i != src){
        //         dist[i]=Integer.MAX_VALUE;//infinity
        //     }
        // }
        Arrays.fill(dist, (int)1e8);
        dist[src] = 0;
        
        //Algorithm O(VE)
        
        for(int i=0;i<V-1;i++){ //O(V)
            //Edges-O(E)
            for(int j=0;j<graph.length;j++){ //vertices
                for(int k=0;k<graph[j].size();k++){ //edges
                    Edge e=graph[j].get(k);
                    
                    int u = j;        // source
                    int v = e.dest;   // destination
                    int wt = e.wt;
                    
                    //relaxation step
                    if(dist[u] != (int)1e8  && dist[u]+wt < dist[v]){
                        dist[v]=dist[u] + wt;
                    }
                }
            }
        }
             // Negative Cycle Detection
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);

                    int u = j;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] != (int) 1e8 &&
                    
                    dist[u] + wt < dist[v]) {
                        return new int[]{-1};
                }
            }
        }
        return dist;
        
    }
}
