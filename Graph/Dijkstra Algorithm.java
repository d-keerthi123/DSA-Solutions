//TC:O(V+ E log V)

class Solution {
    class Pair implements Comparable<Pair>{
        int n;
        int path;
        
        Pair(int n,int path){
            this.n= n;
            this.path=path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path; //path bsed sorting
        }
    }
    
    class Edge {
    int dest;
    int wt;

    Edge(int dest, int wt) {
        this.dest = dest;
        this.wt = wt;
    }
}


    public int[] dijkstra(int V, int[][] edges, int src) {
       //build graph
       ArrayList<Edge>[] graph = new ArrayList[V];
       
       for(int i=0;i<V;i++){
           graph[i]= new ArrayList<>();
       }
       
       for(int i=0;i<edges.length;i++){
           int u=edges[i][0]; //src
           int v=edges[i][1]; //dest
           int w=edges[i][2]; //weight
           
           graph[u].add(new Edge(v,w));
           graph[v].add(new Edge(u,w));
       }
       
       int dist[] = new int[graph.length]; //dist[i] -->src to i
       for(int i=0;i<graph.length;i++){
           if(i != src){
               dist[i]=Integer.MAX_VALUE;
           }
       }
       
       boolean visited[]= new boolean[graph.length];
       PriorityQueue<Pair> pq= new PriorityQueue<>();
       
       pq.add(new Pair(src,0));
       
       while(! pq.isEmpty()){
           Pair curr=pq.remove(); //shortest will  be removed
           
           if(! visited[curr.n]){
               visited[curr.n]= true;
               
               //check neighbours
               for(int i=0;i<graph[curr.n].size();i++){
                   Edge e = graph[curr.n].get(i);
                   
                   int neighbour = e.dest;
                   int wt = e.wt;
                   
                   if(dist[curr.n]+wt <dist[neighbour]){
                       dist[neighbour]=dist[curr.n]+wt;
                       pq.add(new Pair(neighbour, dist[neighbour]));
                   }
               }
           }
       }
       return dist;
    }
}
