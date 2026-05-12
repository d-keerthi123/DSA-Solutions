//TC:O(n)
//Sc:O(n)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // opening bracket
            if(ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } 
            else {

                if(st.isEmpty()) {// no opening brackets or if input is empty
                    return false;
                }

                if(ch == ')' && st.peek() == '(') {
                    st.pop();
                }
                else if(ch == ']' && st.peek() == '[') {
                    st.pop();
                }
                else if(ch == '}' && st.peek() == '{') {
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }
        //If stack is empty → true , If stack still has brackets → false
        return st.isEmpty(); 
    }
}
