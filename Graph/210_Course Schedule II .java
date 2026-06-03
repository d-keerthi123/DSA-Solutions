class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build graph
        ArrayList<Integer>[] graph= new ArrayList[numCourses];
        //create ararylist at each vertex
        for(int i=0;i< numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        //insert edges in graph
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];

            graph[v].add(u); //b -->a 
        }

         //calculate indegree
        int[] indegree= new int[numCourses];
        for(int i=0;i<graph.length;i++){ //array -vertices
            for(int j=0;j<graph[i].size();j++){ //arraylist- edges
                int neighbour=graph[i].get(j);
                indegree[neighbour]++;
            }
        }
       
        return topoSortCheck(graph,numCourses,indegree);
    }
     public int[] topoSortCheck(ArrayList<Integer>[] graph,int numCourses , int[] indegree){
        Queue<Integer> q = new LinkedList<>();

        ArrayList<Integer> ans= new ArrayList<>();
        int count =0;
         // to check how many nodes we visited
        // if count== V then we visited all nodes/vertices which means no cycle exists

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            int curr=q.remove();
            ans.add(curr); 
            
            //check for neighbours
            for(int i=0;i<graph[curr].size();i++){
                int neighbour=graph[curr].get(i);
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.add(neighbour);
                    count++;
                }
            }
        }

        int[] result= new int[numCourses];
        for(int k=0;k<ans.size();k++){
            result[k]=ans.get(k);
        }

        //// no cycle exists which means its possible to complete all courses 
        //then return order of courses
        if(count == numCourses){
            return result; 
            
        }
        //else empty array
        return new int[0];
    }
            
}
