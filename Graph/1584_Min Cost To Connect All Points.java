class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int cost;

        Pair(int node, int cost){
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
    public int minCostConnectPoints(int[][] points) {
        //build graph
        int n=points.length;
        ArrayList<Edge>[] graph= new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        //calculate edges wt
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cost= Math.abs(points[i][0] - points[j][0]) + 
                Math.abs(points[i][1] - points[j][1]);

                graph[i].add(new Edge(j, cost));
                graph[j].add(new Edge(i, cost));
            }
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>();
        boolean[] visited= new  boolean[graph.length];
        pq.add(new Pair(0,0));

        int finalCost=0;

        while(! pq.isEmpty()){
            Pair curr=pq.remove();

            if(! visited[curr.node]){
                visited[curr.node]=true;
                finalCost+=curr.cost;

                //check for neighbours
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    pq.add(new Pair(e.dest,e.wt));
                }
            }
        }
        return finalCost;
    }
}
