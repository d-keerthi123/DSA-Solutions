class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int cost;
        
        Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
        
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
    class Edge{
        int dest;
        int wt;
        
        Edge(int dest,int wt){
            this.dest=dest;
            this.wt=wt;
        }
    }
    public int spanningTree(int V, int[][] edges) {
       
      //build graph
      ArrayList<Edge>[] graph= new ArrayList[V];
      for(int i=0;i<V;i++){
          graph[i]= new ArrayList<>();
      }
      
      for(int i=0;i<edges.length;i++){
          int u=edges[i][0];
          int v=edges[i][1];
          int wt=edges[i][2];
          
          graph[u].add(new Edge(v,wt));
          graph[v].add(new Edge(u,wt));
      }
      PriorityQueue<Pair> pq= new PriorityQueue<>();
      boolean[] visited= new  boolean[V];
      
      pq.add(new Pair(0,0));
      
      int finalCost=0;
      
      while(! pq.isEmpty()){
          Pair curr=pq.remove();
          
          if(!visited[curr.node]){
              visited[curr.node]=true;
              finalCost+=curr.cost;
             
              //for neighbours
              for(int i=0;i<graph[curr.node].size();i++){
                  Edge e=graph[curr.node].get(i);
                  
                  pq.add(new Pair(e.dest,e.wt));
              }
          }
          
      }
      return finalCost;
     
    }
}
