////GeeksForGeeks Question
//TC:O(n)
//SC:O(n)

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        
        int n=arr.length;
        Stack<Integer> s= new Stack<>();
        
        int nextSmaller[]=new int[n];
        
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextSmaller[i]=-1;
            }else{
                nextSmaller[i]=s.peek();
            }
            s.push(arr[i]);
        }
        
            
            ArrayList<Integer> ans= new ArrayList<>();
            for(int i=0;i<nextSmaller.length;i++){
                ans.add(nextSmaller[i]);
            }
            return ans;
    }
}
