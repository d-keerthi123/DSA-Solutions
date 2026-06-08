class Solution {
    class Info{
        int node;
        int price;
        int stops;

        Info(int node,int price,int stops){
            this.node=node;
            this.price=price;
            this.stops=stops;
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
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //build graph
        ArrayList<Edge>[] graph= new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i]= new ArrayList<>();
        }
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0]; //src
            int v=flights[i][1]; //dest
            int w=flights[i][2]; //cost

            graph[u].add(new Edge(v,w));
        }

        int cost[]=new int[n];
        for(int i=0;i<cost.length;i++){
            if(i!= src){
                cost[i]=Integer.MAX_VALUE;
            }
        }
        
        Queue<Info> q= new LinkedList<>();
        q.add(new Info(src,0,0));

        while(! q.isEmpty()){
            Info curr=q.remove();
            if(curr.stops > k){
                break;
            }
             //check for neighbours
               for(int i=0;i<graph[curr.node].size();i++){
                   Edge e = graph[curr.node].get(i);
                   
                   int neighbour = e.dest;
                   int wt = e.wt;

                   int newCost = curr.price + wt;

                    if(newCost < cost[neighbour] && curr.stops<=k){
                       cost[neighbour] = newCost;
                       q.add(new Info(neighbour, newCost,curr.stops+1));
                   }
               }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}

