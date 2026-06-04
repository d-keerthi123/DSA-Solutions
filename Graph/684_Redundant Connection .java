//Time Complexity = O(N²)
//There are N edges.For every edge, you may run a DFS:
//dfs(graph, u, v, visited)
//In the worst case, DFS can visit almost all vertices and edges already present in the graph.
//So each DFS costs: O(N) and you do it for up to N edges:
//O(N) × O(N) = O(N²)

//SC:O(N)

class Solution {

    public boolean dfs(HashMap<Integer,ArrayList<Integer>> graph , int u,int v, boolean[] visited){
        if(u == v){ //u alreaddy reached v which means they are already connected the return true
            return true;
        }
        visited[u]=true;

        //check for neighbours
        for(int i=0;i<graph.get(u).size();i++){
            int neighbour=graph.get(u).get(i);
            if(!visited[neighbour]){
                if(dfs(graph,neighbour,v,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        //build graph
        int V=edges.length;
        HashMap<Integer,ArrayList<Integer>> graph= new HashMap<>();
        
       for (int i = 0; i < V; i++) { 
        int u = edges[i][0]; 
        int v = edges[i][1]; 

        //Each connectivity check should start fresh: thats why we create visited array inside loop
        boolean visited[]= new boolean[V+1];

        // If both nodes already exist and a path exists, 
        // then current edge is redundant
        if(graph.containsKey(u) && graph.containsKey(v) && dfs(graph, u, v, visited)){
            return edges[i];
            }

            graph.putIfAbsent(u, new ArrayList<>()); 
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(v);
            graph.get(v).add(u);
       }
       return new int[0];
    }
}
