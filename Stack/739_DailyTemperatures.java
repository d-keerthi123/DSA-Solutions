class Solution {
    
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s=new Stack<>();
        int n=temperatures.length;

        int result[]= new int[n];
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && temperatures[s.peek()] <=temperatures[i]){
                s.pop();
            }
            if(s.isEmpty()){
                result[i]=0;
            }else{
                result[i]=s.peek() -i; //nextWarmerIndex - currentIndex
            }
            s.push(i);
        }
        return result;
    }
}
