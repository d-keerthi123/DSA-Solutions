//TC:O(V +E Log E)

class Solution {
   
    class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int cost;

        Edge(int src,int dest, int cost){
            this.src=src;
            this.dest=dest;
            this.cost=cost;
        }

        @Override
        public int compareTo(Edge p2){
            return this.cost-p2.cost; 
        }
    }
    static int parent[];
    static int rank[];

    public static void init(int V){
        for(int i=0;i<V;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }

    //find operation
    public static int find(int x){
        if(x==parent[x]){
            return x;
        }

        return parent[x]=find(parent[x]);
    }

    //union operation
    public static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);

        if(rank[parA] ==rank[parB]){
            parent[parB]=parA;
            rank[parA]++;
        }
        else if(rank[parA]< rank[parB]){
             parent[parA]=parB; //smaller tree should go under the larger tree:
        }else{
            parent[parB]=parA;
        }
    }
    
    public int minCostConnectPoints(int[][] points) {
        //build graph
        int V = points.length;
        parent=new int[V];
        rank=new int[V];
        init(V);
        ArrayList<Edge> edges = new ArrayList<>();

        
        //calculate edges wt
        for(int i=0;i<V;i++){ 
            for(int j=i+1;j<V;j++){
                int cost= Math.abs(points[i][0] - points[j][0]) + 
                Math.abs(points[i][1] - points[j][1]);

                edges.add(new Edge(i, j, cost));
            }
        }

        Collections.sort(edges); //sort edges O(ElogE)
        int cost=0;
        int count=0;

        for(int i=0;count<V-1;i++){ //O(V)
            Edge e= edges.get(i);

            int parA=find(e.src);//src - a
            int parB=find(e.dest);//dest- b

            if(parA != parB){
                union(e.src,e.dest);
                cost+= e.cost;
                count++;
            }
        }
        return cost;
    }
}
