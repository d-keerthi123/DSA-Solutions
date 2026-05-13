//TC:O(n) 
//nsr[] runs n times, each element is push once and poped once same with nsl[] and also for loop runs n times
//O(n) + O(n) + O(n) = O(n)
//why not O(n²) because of while loops:
//Although there are nested while loops, every element is pushed and popped only once per pass, so total stack operations are linear.

//SC:O(n) 
//bcz of stack, nsr[], nsl[]    O(n)+O(n)+O(n)=O(n) ignore constants

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s= new Stack<>(); //stores indices
        int n=heights.length;
        //next smaller right
        int nsr[]=new int[n];
        for(int j=n-1;j>=0;j--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[j]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[j]=n;
            }else{
                nsr[j]=s.peek();
            }
            s.push(j);
        }

        //Important - before finding nsl we need to clear the stack
        s.clear();

        //next smaller left
        int nsl[]=new int[n];
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }

        int maxArea=Integer.MIN_VALUE;
    
        for(int k=0;k<n;k++){
            int area=heights[k] * (nsr[k]-nsl[k]-1);
            if(area > maxArea){
                maxArea=area;
            }
        }
        return maxArea;
    }
}
