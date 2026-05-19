

class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        Stack<Integer> tempS= new Stack<>();//temporary stack to store elements(sorted)
        
        //first
        tempS.add(st.pop());
        
       while(!st.isEmpty()){
           
           int curr=st.pop();
           
           while(!tempS.isEmpty() && tempS.peek() < curr  ){
               
               st.push(tempS.pop());
               

           }
           tempS.push(curr);
       }
       
       while(!tempS.isEmpty()){
           st.push(tempS.pop());
       }
       
    }
}
