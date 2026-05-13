//Approach 1:
//push : O(n) and pop() , peek() : O(1)
class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
=====================================================================================================================================================
//Approach 2:
//pop O(n) and peek O(n)
//push O(1)
    class MyQueue {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
       while(!s1.isEmpty()){
        s2.push(s1.pop());
       }

       int result=s2.pop();

       while(!s2.isEmpty()){
        s1.push(s2.pop());
       }
       return result;
    }
    
    public int peek() {
        while(!s1.isEmpty()){
        s2.push(s1.pop());
       }

       int result=s2.peek();

       while(!s2.isEmpty()){
        s1.push(s2.pop());
       }
       return result;
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}


