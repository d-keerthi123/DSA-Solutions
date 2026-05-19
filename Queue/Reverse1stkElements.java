//TC:O(n)
//SC:O(n)

class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        
         
        Stack<Integer> s= new Stack<>();
        int n=q.size();
        
        if(q.size() <k){
            return q;
        }
        for(int i=0;i<k ;i++){ //remove 1st k elements from q and add in stack
            s.push(q.remove());
        }
        while(!s.isEmpty()){ //until stack is empty ,pop elements and add in queue
            q.add(s.pop());
            
        }
        for(int i=0;i<n-k;i++){
            q.add(q.remove()); //add n-k elements in the front at the back
        }
        
        return q;
    }
}
