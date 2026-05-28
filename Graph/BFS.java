//TC:O(V+E) V or E , the greater one controls the bfs Tc
//SC:O(V)

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[]= new boolean[adj.size()];
        ArrayList<Integer> ans= new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        
        q.add(0);//src 0
        
        while(!q.isEmpty()){
            
            int curr=q.remove();
            
            if(!visited[curr]){
                
                visited[curr]=true;
                
                ans.add(curr);
                
                //get neighbours of curr node 
                for(int i=0;i<adj.get(curr).size();i++){
                   int neighbour =adj.get(curr).get(i); 
                    q.add(neighbour);
                }
            }
        }
        return ans;
    }
}
