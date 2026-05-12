//GeeksForGeeks Question
//TC : O(n^2)
//SC:  O(n) Recursive call stack depth=n and No extra data structures used

class Solution {
    
    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()){
            return;
        }
        int top=st.pop();
        reverseStack(st);
        pushAtBottom(st,top);
    }
    
    public static void pushAtBottom(Stack<Integer> st,int data){
        //when stack becomes empty
        if(st.isEmpty()){
            st.push(data);
            return;
        }
        int top=st.pop();
        pushAtBottom(st, data);
        st.push(top);
    }
}
