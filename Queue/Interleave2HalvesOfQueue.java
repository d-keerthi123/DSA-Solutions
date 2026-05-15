//TC:O(n)
//SC:O(n)

class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        Queue<Integer> first= new LinkedList<>();
        
        int size=q.size();
        
       for(int i=0;i<size/2;i++){
           first.add(q.remove());
       }
       while(!first.isEmpty()){
           q.add(first.remove());
           q.add(q.remove());
       }
    }
}
