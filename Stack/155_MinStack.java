class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;
    

    public MinStack() {
        s= new Stack<>();
        minStack=new  Stack<>();
    }
    
    public void push(int val) {//O(1)
        s.push(val);
        if(minStack.isEmpty()){
            minStack.push(s.peek());
        }
        else if (s.peek()<= minStack.peek()){
            minStack.push(s.peek());
        }
        
    }
    
    public void pop() {//O(1)
       int removed=s.pop();
       if(removed == minStack.peek()){
        minStack.pop();
       }
    }
    
    public int top() { //O(1)
        int top=s.peek();
        return top;
    }
    
    public int getMin() {//O(1)
        if(s.isEmpty()){
            return Integer.MIN_VALUE;
        }
        return minStack.peek();
    }
}
