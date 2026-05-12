//GeeksForGeeks Quetsion
//TC:O(n) Each element is:pushed once into stack and popped at most once from  O(2n)
//for loop runs n times
//O(n + n) = O(n)

//SC:O(n) bcz of we are using stack


class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> s= new Stack<>();
        
        int n=arr.length;
        int nextGreater[]= new int[n];
        for(int i=n-1;i>=0;i--){
            while( !s.isEmpty() && s.peek()<=arr[i] ){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i]=-1;
            }else{
                nextGreater[i]=s.peek();
            }
            s.push(arr[i]);
        }
        
        ArrayList<Integer> ans= new ArrayList<>();
        for(int i=0;i<nextGreater.length;i++){
            ans.add(nextGreater[i]);
        }
        
        return ans;
    }
}
