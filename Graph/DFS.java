class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans= new ArrayList<>();
        boolean[] visited=new boolean[adj.size()];
        
        Helper(adj, 0, visited,ans);
        return ans;
        
    }
    
    public void  Helper(ArrayList<ArrayList<Integer>> adj, int curr, boolean[] visited,
    ArrayList<Integer> ans){
       
        ans.add(curr);
        visited[curr]=true;
        
        //call for its neighbous
        for(int i=0;i<adj.get(curr).size();i++){
            int neighbour=adj.get(curr).get(i);
            
            if(!visited[neighbour]){
                Helper(adj,neighbour,visited,ans);
            }
        }
        
    }
}
