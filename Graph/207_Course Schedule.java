class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build graph
        ArrayList<Integer>[] graph= new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]= new ArrayList<>();
        }

        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];

            graph[u].add(v);
        }

        //calculate indegree
        int[] indegree= new int[numCourses];
        for(int i=0;i<graph.length;i++){ //array -vertices
            for(int j=0;j<graph[i].size();j++){ //arraylist- edges
                int neighbour=graph[i].get(j);
                indegree[neighbour]++;
            }
        }
        //if cycle exsists -->not possible
        return topoSortCheck(graph,numCourses,indegree);

    }

    public boolean topoSortCheck(ArrayList<Integer>[] graph,int numCourses , int[] indegree){
        Queue<Integer> q = new LinkedList<>();
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
        if(count == numCourses){
            return true; // no cycle exists which means its possible to complete all courses
        }

        return false;
    }
}
