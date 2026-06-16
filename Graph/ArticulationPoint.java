//TC:O(V + E)
class Solution {
   
    public void dfs(ArrayList<ArrayList<Integer>> adj,int curr,int par,boolean vis[],
    int dt[],int low[],int time,boolean isArticulation[]){
        
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        int children=0;
        
        //get neighbours of curr
        for(int i=0;i<adj.get(curr).size();i++){
            int neighbour=adj.get(curr).get(i);
            
            if(neighbour == par){
                continue;
            }else if(vis[neighbour]){
                low[curr]=Math.min(low[curr],dt[neighbour]);
            }else{
                dfs(adj,neighbour,curr,vis,dt,low,time,isArticulation);
                low[curr]=Math.min(low[curr],low[neighbour]);
                
                //check for articulation point
                if(par !=-1 && dt[curr]<= low[neighbour]){
                    isArticulation[curr]=true;
                }
                children++;
            }
        }
        
        if(par ==-1 && children>1){
            isArticulation[curr]=true;
        }
    }
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,
                                                 ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        int dt[]=new int[V];
        int low[]=new int[V];
        int time=0;
        // Array to flag nodes; eliminates duplicates and helps output in sorted order
        boolean isArticulation[] = new boolean[V];
        
        ArrayList<Integer> ans= new ArrayList<>();
        
        boolean vis[]= new boolean[V];
        
        //handle disconnected components
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(adj,i,-1,vis,dt,low,time,isArticulation);
            }
        }
        
        for(int i=0;i<V;i++){
            if(isArticulation[i]){
                ans.add(i);
            }
        }
        if(ans.size()==0){
            ans.add(-1);
        }
        return ans;
    }
}
