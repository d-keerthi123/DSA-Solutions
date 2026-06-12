//TC:O(V+E)

class Solution {
    public void dfs(ArrayList<Integer>[] graph,int curr,int par,int[] dt, int[] low, int time,boolean[] vis,List<List<Integer>> ans){

        vis[curr]=true;
        dt[curr]=low[curr]=++time;

        for(int i=0;i<graph[curr].size();i++){
            int neighbour=graph[curr].get(i);

            if(neighbour == par){
                continue;
            }
            else if(! vis[neighbour]){
                dfs(graph,neighbour,curr,dt,low,time,vis,ans);
                low[curr]=Math.min(low[curr],low[neighbour]);
                if(dt[curr]<low[neighbour]){
                    List<Integer> bridge=new ArrayList<>();
                    bridge.add(curr);
                    bridge.add(neighbour);
                    ans.add(bridge);
                }
            }
            else{
                low[curr]=Math.min(low[curr],dt[neighbour]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        //build graph
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < connections.size(); i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] dt=new int[n]; //discovery time of the node
        int[] low=new int[n]; // lowest discovery time of all neighbours
        int time=0;
        boolean vis[]= new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(graph,i,-1,dt,low,time,vis,ans);
            }
        }
        return ans;
    }
}
